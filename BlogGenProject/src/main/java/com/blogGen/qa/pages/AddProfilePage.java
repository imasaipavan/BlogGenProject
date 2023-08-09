package com.blogGen.qa.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddProfilePage {

	public WebDriver driver;
	public AddProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static WebElement profilebutton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@href='/settings/profile']"));
	}

	public static WebElement inviteUserButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='sc-fqkvVR geXwtO add']"));
	}

	public static WebElement emailInputBox(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='email']"));
	}
	public static WebElement sendButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-fqkvVR jXIpWA']"));
	}
	public static WebElement invitedUserSuccessMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Invitation sent successfully')]"));
	}
	public static WebElement closeIcon(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@alt='close icon'])[2]"));
	}
	public static WebElement searchUser(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@placeholder='Search Profile']"));
	}
	public static WebElement newUser(WebDriver driver) {
		return driver.findElement(By.xpath("//td[@colspan='2']"));
	}
	public static WebElement settingPage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@title='Settings']"));
	}


	public static void addNewUser(WebDriver driver) throws InterruptedException {
		settingPage(driver).click();
		Thread.sleep(3000);
		profilebutton(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(inviteUserButton(driver)));
		inviteUserButton(driver).click();
		Thread.sleep(2000);
		long time = System.currentTimeMillis();
		emailInputBox(driver).sendKeys("Test"+time+"@gmail.com");
		Thread.sleep(2000);
		sendButton(driver).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(invitedUserSuccessMessage(driver)));
		Thread.sleep(2000);
		Assert.assertTrue(invitedUserSuccessMessage(driver).isDisplayed());
		closeIcon(driver).click();
		Thread.sleep(2000);
		searchUser(driver).sendKeys("Test"+time);
		wait.until(ExpectedConditions.visibilityOf(newUser(driver)));
		Thread.sleep(2000);
		Assert.assertTrue(newUser(driver).isDisplayed());

	}
	
	public static void addNewUserWithoutEnteringEmail(WebDriver driver) throws InterruptedException {
		settingPage(driver).click();
		Thread.sleep(3000);
		profilebutton(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(inviteUserButton(driver)));
		inviteUserButton(driver).click();
		Thread.sleep(2000);
		Assert.assertFalse(sendButton(driver).isEnabled());
		Thread.sleep(2000);
	}





}
