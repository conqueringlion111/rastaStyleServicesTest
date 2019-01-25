package com.AutomationTestHelper.helper;

import org.openqa.selenium.WebDriver;

import com.AutomationTest.pages.PageBase;

public class Alerts extends PageBase{
	
	public Alerts(WebDriver driver) {
		
		super(driver);
	}
	
	public void selectCancelOnAlertBox() {
		
		driver.switchTo().alert().dismiss();
				
	}
	
	public void selectAcceptOnAlertBox() {
		
		driver.switchTo().alert().accept();

	}
	
	public String getTextOnAlertBox() {
		
		return driver.switchTo().alert().getText();
		
	}
	
	public void sendKeysToAlertBox(String sendKeysAlert) {
		
		driver.switchTo().alert().sendKeys(sendKeysAlert);
	}

}