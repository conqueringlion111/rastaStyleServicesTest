package com.AutomationTest.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.AutomationTest.pages.PageBase;

public class HomePageLocators extends PageBase {
	
	public HomePageLocators(WebDriver driver) {
		super(driver);
	}
	
	public By topMainMenuBarLocCss = By.cssSelector(".bBottom .slds-context-bar");


}
