package com.AutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		WebElement loginForm = driver.findElement(By.xpath("//div[@id='content']/div[3]"));
		WebElement userNameField = driver.findElement(By.id("username"));		
		By userNmField = By.id("username");
		WebElement pwField = driver.findElement(By.id("password"));
		By pwFieldBy = By.id("password");
		WebElement loginBtn = driver.findElement(By.id("Login"));
		try {
		wait.waitForVisibOfWebElement(loginForm, 15);
		} catch(Exception e) {
			System.out.println("error waiting for login form div, refreshing the page");
			driver.navigate().refresh();
			Thread.sleep(1000);
			wait.waitForVisibOfWebElement(loginForm, 15);
		}
		wait.waitForPresenseOfWebElementBy(userNmField);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		wait.waitForPresenseOfWebElementBy(pwFieldBy);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		wait.waitForVisibOfWebElement(loginBtn, 15);
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
	
	public void startText(){
		System.out.println("starting test");
	}

}
