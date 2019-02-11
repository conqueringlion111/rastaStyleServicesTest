package com.AutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.AutomationTestHelper.helper.Waits;
import com.AutomationTest.pages.HomePage;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	Waits wait = new Waits(driver);
	Actions action = new Actions(driver);
	
	public HomePage verifySuccessfulLogin() throws InterruptedException {
		
		WebElement topMainMenuBar = driver.findElement(By.cssSelector(".bBottom .slds-context-bar"));
		try {
			wait.waitForVisibOfWebElement(topMainMenuBar, 15);
		}catch(Exception e) {
			System.out.println("Error waiting for top main menu bar");
			Thread.sleep(1500);
		}
		Assert.assertTrue(driver.findElement(By.cssSelector(".bBottom .slds-context-bar")).isDisplayed(), "Menu bar is not available. Login is not successful!");
		System.out.println("The menu bar has displayed, login is successful --> Assertion Passed!");
		
		return new HomePage(driver);
	}
	
	

}
