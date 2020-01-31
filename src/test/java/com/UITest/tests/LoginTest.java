package com.UITest.tests;

import org.testng.annotations.Test;

import com.framewerk.TestBase;

public class LoginTest extends TestBase {
	
	@Test(dataProvider = "dataProvider", description = "simple test to assert successful login")
	public void loginTest(String username, String password) throws InterruptedException {
		
		loginpage.login(username, password)
				 .verifySuccessfulLogin();
	}

}
