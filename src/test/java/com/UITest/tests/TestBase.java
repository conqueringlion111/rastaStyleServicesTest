package com.UITest.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.AutomationTestHelper.helper.TestResultsTR;
import com.AutomationTest.pages.LoginPage;
import com.AutomationTest.util.JsonReader;
import com.AutomationTest.util.WebDriverHelper;

public class TestBase {
	
	protected boolean isPassed;
	protected WebDriver driver;
	protected LoginPage loginpage;
	protected static Properties testConfig;
	public String baseUrl;
	
	public static String TEST_RUN_ID                = "runNumber";
    public static String TESTRAIL_USERNAME          = "testRailUsername";
    public static String TESTRAIL_PASSWORD          = "testRailPassword";
    public static String RAILS_ENGINE_URL           = "sumoSchedulingTestRailURL";
    
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
	
	@BeforeSuite()
	public void beforSuite() throws FileNotFoundException, IOException {
		testConfig = new Properties();
		testConfig.load(new FileInputStream("UITestConfig.properties"));
		
	}

	@BeforeMethod
	
	@Parameters({"browserRemote"})
	
	  public void beforeMethod(@Optional String browserRemote) throws MalformedURLException, InstantiationException, IllegalAccessException
	  {
		
		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"), testConfig.getProperty("parallel"), browserRemote);
		
		baseUrl = testConfig.getProperty("baseUrl");	
		driver.get(baseUrl);

		loginpage = new LoginPage(driver);

	}

	@DataProvider(name = "dataProvider")
	 public Object[][] passData(Method method) throws IOException, ParseException
		{
		 	testConfig = new Properties();
			testConfig.load(new FileInputStream("UITestConfig.properties"));
			
			return JsonReader.getdata(testConfig.getProperty("jsonDataLocation")+"TestDataSet.json", method.getName());
		}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception
	  {
		 TestResultsTR testResults = new TestResultsTR();
		 String testCaseNumber = result.getName();
		 testCaseNumber = testCaseNumber.replaceAll("[^\\d.]",  "");
		 System.out.println("The value of testCaseNumber is " + testCaseNumber);		 

			 if(testCaseNumber.length() > 1) {
				 if(ITestResult.FAILURE==result.getStatus()) {				 
						try{
							TakesScreenshot screenshot = (TakesScreenshot)driver;
							File srs = screenshot.getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(srs, new File(".\\printscreen\\failureprintscreen_"+result.getName()+".png"));
							System.out.println("Successfully captured a screenshot");
						}catch (Exception e){
							System.out.println("Exception while taking screenshot "+e.getMessage());
						}
						try {
							testResults.addResultForTestCase(TEST_RUN_ID, TESTRAIL_USERNAME, TESTRAIL_PASSWORD, RAILS_ENGINE_URL, testCaseNumber, TEST_CASE_FAILED_STATUS, "");
						} catch(Exception e) {
							System.out.println("Exception sending test status to testrail, verify test case number exists in testrail run group");
						}
					 }
					 else {
						 try {
							 testResults.addResultForTestCase(TEST_RUN_ID, TESTRAIL_USERNAME, TESTRAIL_PASSWORD, RAILS_ENGINE_URL, testCaseNumber, TEST_CASE_PASSED_STATUS, "");
						 } catch(Exception e) {
							 System.out.println("Exception sending test status to testrail, verify test case number exists in testrail run group");
						 }
					 }
			 }
			 
			 else {
				 if(ITestResult.FAILURE==result.getStatus()) {				 
						try{
							TakesScreenshot screenshot = (TakesScreenshot)driver;
							File srs = screenshot.getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(srs, new File(".\\printscreen\\failureprintscreen"+result.getName()+".png"));
							System.out.println("Successfully captured a screenshot");
						}catch (Exception e){
							System.out.println("Exception while taking screenshot "+e.getMessage());
						}					
				 }						 
			 }
			 
			 WebDriverHelper.quitDriver(driver);
	}

}
