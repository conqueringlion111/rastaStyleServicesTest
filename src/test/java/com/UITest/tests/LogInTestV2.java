package com.UITest.tests;

import org.testng.annotations.Test;

import com.AutomationTest.locators.HomePageLocators;
import com.AutomationTest.locators.LoginPageLocators;
import com.AutomationTest.util.CommonSeleniumActions;
import com.AutomationTestHelper.helper.ValidationHelper;
import com.AutomationTestHelper.helper.Waits;
import com.UITest.testbase.TestBase;

public class LogInTestV2 extends TestBase {
	
		
	@Test(dataProvider = "dataProvider", description = "test using getWebElement method from CommonSeleniumActions class ")
	public void logInV2(String username, String password, String errMsg, String successMsg) {
		
		Waits wait = new Waits(driver);
		LoginPageLocators lPL = new LoginPageLocators(driver);
		HomePageLocators hPL = new HomePageLocators(driver);
		CommonSeleniumActions comSA = new CommonSeleniumActions(driver);
		ValidationHelper vH = new ValidationHelper(driver);
		
		wait.waitForPresenseOfWebElementBy(lPL.loginFormX);
		wait.waitForPresenseOfWebElementBy(lPL.usernameField);
		comSA.selClearField(comSA.getWebElement(lPL.usernameField));
		comSA.selSendKeys(comSA.getWebElement(lPL.usernameField), username);
		comSA.selClearField(comSA.getWebElement(lPL.passwordField));
		comSA.selSendKeys(comSA.getWebElement(lPL.passwordField), password);
		comSA.selClick(comSA.getWebElement(lPL.loginBtnID));
		vH.verifyElementVisible(hPL.topMainMenuBarLocCss, errMsg, successMsg);
	}

}
