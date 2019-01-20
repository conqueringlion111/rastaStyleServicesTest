package com.AutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.AutomationTestHelper.helper.Waits;
import com.AutomationTest.pages.HomePage;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	Waits wait = new Waits(driver);
	Actions action = new Actions(driver);
	
	public HomePage login(String username, String password) throws InterruptedException
	{
		try {
		wait.waitForElementByXPath("//div[@id='content']/div[3]");
		} catch(Exception e) {
			System.out.println("error waiting for login form div, refreshing the page");
			driver.navigate().refresh();
			Thread.sleep(1500);
			wait.waitForElementByXPath("//div[@id='content']/div[3]");
		}
		wait.waitForPresenseElementByID("username");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		wait.waitForPresenseElementByID("password");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		wait.waitForPresenseElementByID("Login");
		try {
		 driver.findElement(By.id("Login")).click();
		 Thread.sleep(2500);
		} catch(Exception e) {
		System.out.println("error clicking on login button trying again");
		driver.findElement(By.xpath("//div[@id='theloginform']/form/input[2]")).click();
		Thread.sleep(2500);
		}
		
		return new HomePage(driver);
		
	}

}
