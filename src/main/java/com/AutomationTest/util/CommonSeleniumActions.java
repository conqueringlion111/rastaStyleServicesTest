package com.AutomationTest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AutomationTest.pages.PageBase;

public class CommonSeleniumActions extends PageBase {
	
	public CommonSeleniumActions(WebDriver driver) {
		super(driver);
	}
		
	public void selClick(WebElement webElemLoc) {
		webElemLoc.click();
	}
	
	public void selClearField(WebElement fieldWebElemLoc) {
		fieldWebElemLoc.clear();
	}
	
	public void selSendKeys(WebElement webElemLoc, String inputStr) {
		webElemLoc.sendKeys(inputStr);
	}
	/**
	 * method to create WebElement with By param
	 * @param byLocVal
	 * @return
	 */
	public WebElement getWebElement(By byLocVal) {
		return driver.findElement(byLocVal);
	}

}
