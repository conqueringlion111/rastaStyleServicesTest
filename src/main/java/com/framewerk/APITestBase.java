package com.framewerk;

import com.AutomationTest.util.JsonReader;
import com.AutomationTestHelper.helper.TestResultsTR;
import com.appconstants.ApplicationConstants;
import com.helper.OAuth2;
import com.helper.TimeStamp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Properties;

public class APITestBase {
	
	protected static Properties apiTestConfig;
	private String envURL;
	protected static String baseURI = "";
	protected static String authenticationBaseURI = "";
	protected long accessTokenTimeStampMS;
	private static final long EXPIRATION_TIME_LIMIT = 240000;

	public String baseURLStaging;
	public String baseURLProd;
	public String baseURIReqres;
	public String baseURL;
	public String timeLimit;
	public String timeLimitLStr;
	public int timeLimitInt;
	public String tileKey1Prod;
	public String tileKey2Prod;
	public String authorization;
	public String xAPIKey;
	
	public static String TEST_RUN_ID                = "run number";
    public static String TESTRAIL_USERNAME          = "ptosh@rbshoes.com";
    public static String TESTRAIL_PASSWORD          = "legalizeIt";
    public static String RAILS_ENGINE_URL           = "https://rbshoes.testrail.net/";
    
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
	
	@BeforeSuite()
	public void setAPITestConfig() throws FileNotFoundException, IOException {
		apiTestConfig = new Properties();
		apiTestConfig.load(new FileInputStream("APITestConfig.properties"));
		if(System.getProperty("target.env")!= null) {
			envURL = System.getProperty("target.env");
		}
		else {
			envURL = apiTestConfig.getProperty("baseURL");
		}
		baseURI = envURL;
		authenticationBaseURI = apiTestConfig.getProperty("authenticationURI");
		new OAuth2(ApplicationConstants.ATL_ACCT_MANAGER, ApplicationConstants.PASSWORD, ApplicationConstants.GRANT_TYPE,
				ApplicationConstants.CLIENT_ID, ApplicationConstants.CLIENT_SECRET);
		new TimeStamp();
		accessTokenTimeStampMS = TimeStamp.getTimeStampMS();
		baseURLStaging = apiTestConfig.getProperty("baseURLStaging");
		baseURLProd = apiTestConfig.getProperty("baseURLProd");
		baseURL = apiTestConfig.getProperty("baseURLStaging");
		baseURIReqres = apiTestConfig.getProperty("baseReqresURI");
		timeLimit = apiTestConfig.getProperty("timeLimit");
		timeLimitLStr = apiTestConfig.getProperty("timeLimitL");
		tileKey1Prod = apiTestConfig.getProperty("tileKey1Prod");
		tileKey2Prod = apiTestConfig.getProperty("tileKey2Prod");
		authorization = apiTestConfig.getProperty("authorization");
		xAPIKey = apiTestConfig.getProperty("xAPIKey");
		timeLimitInt = Integer.parseInt(timeLimit);
	}

	@BeforeMethod
	
		public void verifyOAuth2ExpirationTime() {
		if(TimeStamp.getTimeStampMS() - accessTokenTimeStampMS > EXPIRATION_TIME_LIMIT) {
			accessTokenTimeStampMS = TimeStamp.getTimeStampMS();
			new OAuth2(ApplicationConstants.ATL_ACCT_MANAGER, ApplicationConstants.PASSWORD, ApplicationConstants.GRANT_TYPE,
					ApplicationConstants.CLIENT_ID, ApplicationConstants.CLIENT_SECRET);
		}
	}

	@DataProvider(name = "dataProvider")
	 public Object[][] passData(Method method) throws IOException, ParseException {
		apiTestConfig = new Properties();
		apiTestConfig.load(new FileInputStream("APITestConfig.properties"));
			
		return JsonReader.getdata(apiTestConfig.getProperty("jsonDataLocation")+"RestAPITestValidationData.json", method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception
	  {
		 TestResultsTR testResults = new TestResultsTR();
		 String testCaseNumber = result.getName();
		 testCaseNumber = testCaseNumber.replaceAll("[^\\d.]",  "").substring(3);
		 System.out.println("The value of testCaseNumber is " + testCaseNumber);		 

			 if(testCaseNumber.length() > 1) {
				 if(ITestResult.FAILURE==result.getStatus()) {				 
						
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
			 
						 
	}

}
