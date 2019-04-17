package com.AutomationTest.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHelper {
	
	public static WebDriver createDriver(String browser, String runTestFromXMLMultiBrowser, String browserRemote) throws MalformedURLException, InstantiationException, IllegalAccessException
		{
			String osName = System.getProperty("os.name");
			System.out.println(System.getProperty("os.name"));		
			WebDriver driver = null;		
			if(osName.contains("Windows")) {
				
				if(runTestFromXMLMultiBrowser.equalsIgnoreCase("true")) {
					
					if(browserRemote.equalsIgnoreCase("headless")) {						
						WebDriverManager.phantomjs().setup();
					}
					
					else if(browserRemote.equalsIgnoreCase("chromeRemote")) {
						
						System.out.println("Opening Chrome Driver");
						WebDriverManager.chromedriver().setup();
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						ChromeOptions options = new ChromeOptions();
						capability.setBrowserName("chrome");
						options.addArguments("--window-size=1560,1070");
						capability.setPlatform(Platform.ANY);
						driver = new ChromeDriver(options);
						
					}
					else if(browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
						
						System.out.println("Opening Chrome Driver");					
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			            options.addArguments("--headless");	
			            options.addArguments("--window-size=1840,990");
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(options);
						
					}
					else if(browserRemote.equalsIgnoreCase("firefoxRemote")) {
						
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();							
					    capabilities.setCapability("marionette",true);
					    FirefoxOptions options = new FirefoxOptions();
					    options.addArguments("--window-size=1560,1070");
						driver = new FirefoxDriver(options);
						
					}
					
					else if(browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
						
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);					    
					    FirefoxOptions options = new FirefoxOptions();
				        options.addArguments("--headless");
				        options.addArguments("--window-size=1840,990");
						driver = new FirefoxDriver(options);
						
					}
					
					else if(browserRemote.equalsIgnoreCase("edgeRemote")) {
							
						WebDriverManager.edgedriver().setup();
						EdgeOptions options = new EdgeOptions();
						options.setPageLoadStrategy("eager");
						driver = new EdgeDriver();
							
						}
					
					else if(browserRemote.equalsIgnoreCase("chromeGalaxyS5Headless")) {
						
						Map<String, String> mobileEmulation = new HashMap<String, String>();
						mobileEmulation.put("deviceName", "Galaxy S5");						
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            
			            options.setExperimentalOption("mobileEmulation", mobileEmulation);
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			            options.addArguments("--headless");
			            driver = new ChromeDriver(capabilities);							
					}
					
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
				else {
					
					if(browser.equalsIgnoreCase("headless")) {
						
						WebDriverManager.phantomjs().setup();
						
					}
					
					else if(browser.equalsIgnoreCase("Firefox")) {
							
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
					    FirefoxOptions options = new FirefoxOptions();
					    options.addArguments("--window-size=1560,1070");
						driver = new FirefoxDriver(capabilities);
						
					}
					else if(browser.equalsIgnoreCase("FireFoxHeadless")) {
						
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);					    
					    FirefoxOptions options = new FirefoxOptions();
				        options.addArguments("--headless");
				        options.addArguments("--window-size=1840,990");
						driver = new FirefoxDriver(options);  
						
					}
					else if(browser.equalsIgnoreCase("Chrome"))
					{
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            options.addArguments("--window-size=1560,1070");
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);	            				            
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
			            
					}
					else if(browser.equalsIgnoreCase("ChromeHeadless"))
					{
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.addArguments("--headless");
			            options.addArguments("--window-size=1840,990");
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("chromeGalaxyS5"))
					{
						Map<String, String> mobileEmulation = new HashMap<String, String>();
						mobileEmulation.put("deviceName", "Galaxy S5");
						
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.setExperimentalOption("mobileEmulation", mobileEmulation);
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("IE"))
					{
						WebDriverManager.iedriver().setup();			
						driver = new InternetExplorerDriver();			
					}
					else if(browser.equalsIgnoreCase("Edge"))
					{
						WebDriverManager.edgedriver().setup();
						EdgeOptions options = new EdgeOptions();
						options.setPageLoadStrategy("eager");
						driver = new EdgeDriver();
					}
											
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}
				}
				
			}	
			
			if(osName.contains("Mac")) {
				
				if(runTestFromXMLMultiBrowser.equalsIgnoreCase("true")) {
					
					if(browserRemote.equalsIgnoreCase("headless")) {
						
						WebDriverManager.phantomjs().setup();
					}
					
					else if(browserRemote.equalsIgnoreCase("chromeRemote")) {
						System.out.println("Opening Chrome Driver");
						WebDriverManager.chromedriver().setup();
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						ChromeOptions options = new ChromeOptions();
						capability.setBrowserName("chrome");
						options.addArguments("--window-size=1560,1070");
						capability.setPlatform(Platform.ANY);
						driver = new ChromeDriver(capability);
					}
					else if(browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.addArguments("--headless");
			            options.addArguments("--window-size=1840,990");
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					else if(browserRemote.equalsIgnoreCase("firefoxRemote")) {
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
					    FirefoxOptions options = new FirefoxOptions();
					    options.addArguments("--window-size=1560,1070");
						driver = new FirefoxDriver(capabilities);
					}
					else if(browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {						
						WebDriverManager.firefoxdriver().setup();
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);					    
						    FirefoxOptions options = new FirefoxOptions();
					        options.addArguments("--headless");
					        options.addArguments("--window-size=1840,990");
							driver = new FirefoxDriver(options);
						
					}
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
				else {
				
					if(browser.equalsIgnoreCase("Firefox"))
					{				
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette",true);
					    FirefoxOptions options = new FirefoxOptions();
					    options.addArguments("--window-size=1560,1070");
						driver = new FirefoxDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("firefoxHeadless")) {
						
						WebDriverManager.firefoxdriver().setup();
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);					    
						    FirefoxOptions options = new FirefoxOptions();
					        options.addArguments("--headless");
					        options.addArguments("--window-size=1840,990");
							driver = new FirefoxDriver(options);
						
					}
					else if(browser.equalsIgnoreCase("Chrome"))
					{
						WebDriverManager.chromedriver().setup();
						ChromeOptions options = new ChromeOptions();
						options.addArguments("disable-infobars");
						driver = new ChromeDriver(options);			
						Dimension dim = new Dimension(1840,1070);						
//						driver.manage().window().maximize();
						driver.manage().window().setSize(dim);
					}
					else if(browser.equalsIgnoreCase("ChromeHeadless"))
					{
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.addArguments("--headless");
			            options.addArguments("--window-size=1840,990");
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					else if(browser.equalsIgnoreCase("chromeGalaxyS5"))
					{
						Map<String, String> mobileEmulation = new HashMap<String, String>();
						mobileEmulation.put("deviceName", "Galaxy S5");
						
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.setExperimentalOption("mobileEmulation", mobileEmulation);
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					
					else if(browser.equalsIgnoreCase("chromeGalaxyS5headless"))
					{
						Map<String, String> mobileEmulation = new HashMap<String, String>();
						mobileEmulation.put("deviceName", "Galaxy S5");
						
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			         
			            options.setExperimentalOption("mobileEmulation", mobileEmulation);
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);	
			            options.addArguments("--headless");
			            driver = new ChromeDriver(capabilities);
					}
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}		
				}
			}	
			
			if(osName.contains("Linux")) {
				
				if(runTestFromXMLMultiBrowser.equalsIgnoreCase("true")) {
					
					if(browser.equalsIgnoreCase("headlessRemote")) {
						
						WebDriverManager.phantomjs().setup();
						
					}
					
					else if(browserRemote.equalsIgnoreCase("chromeRemote")) {
						System.out.println("Opening Chrome Driver");					
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
						options.addArguments("--window-size=1560,1070");
			            driver = new ChromeDriver(capabilities);
					}
					else if(browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
						System.out.println("Opening Chrome Driver");					
						WebDriverManager.chromedriver().setup();				
					 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			            ChromeOptions options = new ChromeOptions();
			            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);			            			           
			            options.addArguments("--headless");
			            options.addArguments("--window-size=1840,990");
			            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
			            driver = new ChromeDriver(capabilities);
					}
					
					else if(browser.equalsIgnoreCase("firefoxRemote")) {	
						WebDriverManager.firefoxdriver().setup();
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();							
					    capabilities.setCapability("marionette",true);
					    FirefoxOptions options = new FirefoxOptions();
					    options.addArguments("--window-size=1560,1070");
						driver = new FirefoxDriver(capabilities);		
					}
					else if(browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
						
						WebDriverManager.firefoxdriver().setup();
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);					    
						    FirefoxOptions options = new FirefoxOptions();
					        options.addArguments("--headless");
					        options.addArguments("--window-size=1840,990");
							driver = new FirefoxDriver(options);						
					}
					else
					{
						throw new InvalidParameterException(browserRemote + "- is not a valid web browser for remote driver.");
					}
				}
				
				else {
					
						if(browser.equalsIgnoreCase("headless")) {
							
							WebDriverManager.phantomjs().setup();
							
						}					
						else if(browser.equalsIgnoreCase("Firefox")) {						
							WebDriverManager.firefoxdriver().setup();
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);
						    FirefoxOptions options = new FirefoxOptions();
						    options.addArguments("--window-size=1560,1070");
							driver = new FirefoxDriver(capabilities);
						}
						else if(browser.equalsIgnoreCase("firefoxHeadless")) {	
							System.out.println("Opening Gecko Driver Headless");
							WebDriverManager.firefoxdriver().setup();
							DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						    capabilities.setCapability("marionette",true);					    
						    FirefoxOptions options = new FirefoxOptions();
					        options.addArguments("--headless");
					        options.addArguments("--window-size=1840,990");
							driver = new FirefoxDriver(options);							
						}
						else if(browser.equalsIgnoreCase("Chrome"))
						{
							System.out.println("Opening Chrome Driver");					
							WebDriverManager.chromedriver().setup();				
						 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				            ChromeOptions options = new ChromeOptions();
				            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				            options.addArguments("--window-size=1560,1070");
				            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
				            driver = new ChromeDriver(capabilities);								
						}
						else if(browser.equalsIgnoreCase("ChromeHeadless")) {
							System.out.println("Opening Chrome Driver Headless");					
							WebDriverManager.chromedriver().setup();				
						 	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				            ChromeOptions options = new ChromeOptions();
				            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				            options.addArguments("--headless");
				            options.addArguments("--window-size=1840,990");
				            options.addArguments("disable-infobars");
				            capabilities.setCapability(ChromeOptions.CAPABILITY, options);		            
				            driver = new ChromeDriver(capabilities);								
						}
																
					else
					{
						throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
					}		
				}
			
			}	
			
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

			return driver;
		}
		
		public static void quitDriver(WebDriver driver)
		{
			driver.quit();
		}

}
