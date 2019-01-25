package com.AutomationTestHelper.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.AutomationTest.pages.PageBase;

public class ClickAndDrag extends PageBase {
	
	public ClickAndDrag(WebDriver driver) {
		super(driver);
	}
	
	Actions action = new Actions(driver);
	Waits wait = new Waits(driver);
	
	public void clickAndDragTranspMrkrOnMapDiv(String locator, String x2, String y2) throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement start = driver.findElement(By.xpath(locator));
		int x2Int = Integer.parseInt(x2);
		int y2Int = Integer.parseInt(y2);
		try {
			action.clickAndHold(start);
			Thread.sleep(1000);
			action.moveByOffset(x2Int, y2Int).build().perform();
			Thread.sleep(1000);
			action.release().build().perform();

		}catch(Exception e) {
			System.out.println("Error dragging marker on the map, trying again");
			Thread.sleep(1000);
			action.clickAndHold(start);
			Thread.sleep(1000);
			action.moveByOffset(x2Int, y2Int).build().perform();
			Thread.sleep(1000);
			action.release().build().perform();

		}
	
	}
	
	public void clickAndDragTranspMrkrToOriginalLocOnMapDiv(String locator, String x2, String y2) throws InterruptedException {
		
		WebElement start = driver.findElement(By.xpath(locator));
		int x2Int = Integer.parseInt(x2);
		int y2Int = Integer.parseInt(y2);
		try {

			action.clickAndHold(start);
			Thread.sleep(1000);
			action.moveByOffset(-x2Int, -y2Int).build().perform();
			Thread.sleep(1000);
			action.release().build().perform();
		}catch(Exception e) {
			System.out.println("Error dragging marker on the map, trying again");
			Thread.sleep(1000);
			action.clickAndHold(start);
			Thread.sleep(1000);
			action.moveByOffset(-x2Int, -y2Int).build().perform();
			Thread.sleep(1000);
			action.release().build().perform();
		}
		
		
	}

}
