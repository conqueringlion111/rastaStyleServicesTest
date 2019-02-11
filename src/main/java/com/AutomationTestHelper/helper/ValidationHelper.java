package com.AutomationTestHelper.helper;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.AutomationTest.pages.PageBase;

public class ValidationHelper extends PageBase {
	
	public ValidationHelper(WebDriver driver) {
		super(driver);
	}
	
	Waits wait = new Waits(driver);
	Actions action = new Actions(driver);
	
	/**
	 * method to create an assertion List to assert against multiple text present in repeating tags
	 * example: drop down menu - assertion existing selections are present
	 * pass in a string with all expected selections separated by comma
	 * @param assertDataStr
	 * @return
	 */
	public List<String> getAssertionList(String assertDataStr) {
		List<String> expectedAssertList = Arrays.asList(assertDataStr.split("\\s*,\\s*"));
		return expectedAssertList;
	}
	
	/**
	 * method to assert displayed text in repeated tag against passed in assertion List
	 * @param totTagCountXPath
	 * @param xPathLocA
	 * @param xPathLocB
	 * @param assertList
	 */
	public void verifyAgainstDisplayedDataWithAssertList(String totTagCountXPath, String xPathLocA, String xPathLocB, List<String> assertList) {
		int count = driver.findElements(By.xpath(totTagCountXPath)).size();
		for(int i = 1; i<= count; ++i) {
			System.out.println("asserting against " + driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB)).getText());
			Assert.assertTrue(assertList.contains(driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB)).getText()), ""
					+ "Unexpected data is present --> Assertion Failed");
		}
	}
	
	/**
	 * method to assert against displayed text when multiple data tags exist in each data row
	 * @param totTagCountXPath
	 * @param xPathLocA
	 * @param xPathLocB
	 * @param assertList
	 */
	public void verifyAgainstMultipDemDisplayedDataWithList(String totTagCountXPath, String xPathLocA, String xPathLocB, List<String> assertList) {
		int count = driver.findElements(By.xpath(totTagCountXPath)).size();
		for(int i = 1; i<= count; ++i) {
			/*
			 * execute assertion against multiple tags if more than 1 is avail per record
			 */
			int subCt = driver.findElements(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB)).size();
			if(subCt > 1) {
				for(int j=1; j <= subCt; ++j) {
					System.out.println("asserting against " + driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB + "[" + j + "]")).getText());
					Assert.assertTrue(assertList.contains(driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB + "[" + j + "]")).getText()), ""
							+ "Unexpected data is present --> Assertion Failed");
				}
				
			}
			else {
				System.out.println("asserting against " + driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB)).getText());
				Assert.assertTrue(assertList.contains(driver.findElement(By.xpath(xPathLocA + "[" + i + "]" + xPathLocB)).getText()), ""
						+ "Unexpected data is present --> Assertion Failed");
			}
		}
	}
	
	

}
