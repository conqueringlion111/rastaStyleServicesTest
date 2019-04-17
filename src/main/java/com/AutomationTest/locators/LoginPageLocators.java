package com.AutomationTest.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.AutomationTest.pages.PageBase;
import com.AutomationTestHelper.helper.Waits;

public class LoginPageLocators extends PageBase {
	
	public LoginPageLocators(WebDriver driver) {
		super(driver);
	}
	
	Waits wait = new Waits(driver);
	Actions action = new Actions(driver);
	
	public By loginFormX = By.xpath("//div[@id='content']/div[3]");
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginBtnID = By.id("Login");

}
