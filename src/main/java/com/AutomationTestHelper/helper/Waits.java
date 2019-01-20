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
	
	public void waitForElementByID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 39);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));	
	}
	
	public void waitForElementByIDS(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));	
	}
	
	public void waitForPresenseElementByID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id(elementID)));
	}
	
	public void waitForElementClickableByID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.id(elementID)));	
	}
	
	public void waitForElementClickableByIDB(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.id(elementID)));	
	}
	
	public void waitForTextPresentInElementByID(String elementID, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(elementID), text));
	}
	
	public void waitForVisibilityOfAllElementsID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(
			ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(elementID)));
	}
	
	public void waitForElementInvisibilityByID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(elementID)));
	}
	
	public void waitForElementInvisibilityByIDShort(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(elementID)));
	}
		
	public void waitForElementByClass(String elementClass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
	}
	
	public void waitForElementByCssSel(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCSS)));
	}
	
	public void waitForElementByCssSelS(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCSS)));
	}
	
	public void waitForPresenseElementByCssSel(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
	}
	
	public void waitForElementClickableByCssSel(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector(elementCSS)));
	}
	
	public void waitForTextPresentInElementByCssSel(String elementCss, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(elementCss), text));
	}
	
	public void waitForTextPresentInElementByCssSelB(String elementCss, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(elementCss), text));
	}
	
	public void waitForElementInvisibilityByCssSel(String elementCssSel) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elementCssSel)));
	}
	
	public void waitForElementInvisibilityByCssSelL(String elementCssSel) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elementCssSel)));
	}
	
	public void waitForElementByLinkText(String elementLinkText) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.linkText(elementLinkText)));
	}
	
	public void waitForElementByLinkTextS(String elementLinkText) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.linkText(elementLinkText)));
	}
	
	public void waitForTextPresentInElementByLinkText(String elementLinkText, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(elementLinkText), text));
	}
	
	public void waitForElementClickableByLinkText(String elementLinkText) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.linkText(elementLinkText)));
	}
	
	public void waitForElementByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByXPathL(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByXPathS(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByXPathTres(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByXPathS4(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForPresenseElementByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForPresenseElementByXPathCust(String elementXPath, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForVisibilityOfAllElementsXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(
			ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXPath)));
	}
	
	public void waitForPageTitleToDisplayString(String pageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	public void waitForElementClickableByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(elementXPath)));
	}
	
	public void waitForElementClickableByXPathShort(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(elementXPath)));
	}
	
	public void waitForTextPresentInElementByXPath(String elementXPath, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXPath), text));
	}
	
	public void waitForTextPresentInElementByXPathL(String elementXPath, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXPath), text));
	}
	
	public void waitForTextPresentInElementByXPathS(String elementXPath, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXPath), text));
	}
	
	public void waitForElementToBeSelectedByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(elementXPath)));
	}
	
	public void waitForElementInvisibilityByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 39);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementInvisibilityByXPathLong(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementInvisibilityByXPathShort(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByTagName(String elementTag) {
		WebDriverWait wait = new WebDriverWait(driver, 17);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.tagName(elementTag)));
	}
	
	public void waitForPresenseElementByTagName(String elementTag) {
		WebDriverWait wait = new WebDriverWait(driver, 17);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.tagName(elementTag)));
	}
	
	

}
