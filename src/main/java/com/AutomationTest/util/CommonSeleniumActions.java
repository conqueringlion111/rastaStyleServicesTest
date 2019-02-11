package com.AutomationTest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AutomationTest.pages.PageBase;

public class CommonSeleniumActions extends PageBase {
	
	public CommonSeleniumActions(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * These may not be helpful and redundant but experimenting to see if this helps
	 */
	
	public void selClick(WebElement webElemLoc) {
		webElemLoc.click();
	}
	
	public void selClearField(WebElement fieldWebElemLoc) {
		fieldWebElemLoc.clear();
	}
	
	public void selSendKeys(WebElement webElemLoc, String inputStr) {
		webElemLoc.sendKeys(inputStr);
	}

}
