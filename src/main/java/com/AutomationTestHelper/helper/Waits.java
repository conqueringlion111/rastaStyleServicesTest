package com.AutomationTestHelper.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationTest.pages.PageBase;

public class Waits extends PageBase {
	
	public Waits (WebDriver driver)
	{
		super(driver);
	}
	
	/**
	 * wait for text to be present in web element locator - pass in WebElement
	 *  for example WebElement webElemLoc = driver.findElement(By.xpath("//div[@id='yo']/a"));
	 *  pass in webElemLoc
	 * @param webElemLoc
	 * @param textPresense
	 * @param waitTime
	 */
	public void waitForTextPresentInWebElement(WebElement webElemLoc, String textPresense, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.textToBePresentInElement(webElemLoc, textPresense));
	}
	
	public void waitForVisibOfWebElement(WebElement webElemLocator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElemLocator));	
	}
	
	
	/**
	 * pass in By locator
	 * for example make a By object like this as pass in the object
	 * By userNmField = By.id("username");
	 * 
	 * @param byLocator
	 */
	public void waitForPresenseOfWebElementBy(By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));	
	}
	
	public void waitForInvisibOfWebElement(WebElement webElemLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean bool = wait.until(ExpectedConditions.invisibilityOf(webElemLocator));	
	}
	
	public void waitForWebElementClickable(WebElement webElemLoc) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElemLoc));	
	}
	
	public void waitForElementClickableByLoc(By byElemLoc) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byElemLoc));	
	}
	
	/**
	 * wait for visibility of all elements
	 * Pass in WebElement 
	 * @param elementID
	 */
	public void waitForVisibilityOfAllElementsID(WebElement webElemLoc) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(
			ExpectedConditions.visibilityOfAllElements(webElemLoc));
	}
	
	/**
	 * method to check if element is selected
	 * @param elementXPath
	 */
	public void waitForWebElementToBeSelected(WebElement webElemLoc) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeSelected(webElemLoc));
	}
	
	/**
	 * method to wait for expected pageTitle to display
	 * @param pageTitle
	 * @param waitTime
	 */
	public void waitForPageTitleToDisplayString(String pageTitle, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	

}
