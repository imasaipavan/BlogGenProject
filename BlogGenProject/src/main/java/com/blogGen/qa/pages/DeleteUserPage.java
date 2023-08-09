package com.blogGen.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteUserPage {
	public WebDriver driver;
	public DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static WebElement profilebutton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@href='/settings/profile']"));
	}
	
	public static WebElement deleteCheckbox(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-dZoequ ficHsM checkmark'])[2]"));
	}
	public static WebElement deleteButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='sc-dcJsrY fyOKil']"));
	}
	public static WebElement confirmButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='sc-fqkvVR hughWF']"));
	}
	public static WebElement deletedUserSuccessMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Profiles deleted successfully')]"));
	}
	public static WebElement closeButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@alt='close icon'])[1]"));
	}
    public static WebElement firstUser(WebDriver driver) {
		return driver.findElement(By.xpath("(//td[@colspan='2'])[1]/p"));
    }
    public static WebElement searchUser(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Search Category']"));
    }
    public static WebElement settingsPage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@alt='Settings-icon']"));
	}
    public static WebElement noDataFoundMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//td[@colspan='5']/h2"));
	}
    
    
    public static void deleteUser(WebDriver driver) throws InterruptedException {
    	settingsPage(driver).click();
		Thread.sleep(3000);
		profilebutton(driver).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(deleteCheckbox(driver)));
    	searchUser(driver).sendKeys("test");
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(firstUser(driver)));
    	String firstUserName = firstUser(driver).getText();
    	deleteCheckbox(driver).click();
    	Thread.sleep(2000);
    	deleteButton(driver).click();
    	Thread.sleep(3000);
    	confirmButton(driver).click();
    	Thread.sleep(3000);
    	Assert.assertTrue(deletedUserSuccessMessage(driver).isDisplayed());
    	closeButton(driver).click();
    	Thread.sleep(2000);
    	searchUser(driver).sendKeys(firstUserName);
    	Thread.sleep(4000);
    	Assert.assertTrue(noDataFoundMessage(driver).isDisplayed());

    }
    
    public static void deleteUserWithoutSelectingCategory(WebDriver driver) throws InterruptedException {
    	settingsPage(driver).click();
		Thread.sleep(3000);
		profilebutton(driver).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(deleteCheckbox(driver)));
		Assert.assertFalse(deleteButton(driver).isEnabled());
    }

	
  
	
	
	
	
}
