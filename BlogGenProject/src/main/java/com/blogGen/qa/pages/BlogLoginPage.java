package com.blogGen.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BlogLoginPage {
	WebDriver driver;
	
	public BlogLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 
	@FindBy(how=How.ID, using = "email")
	public static WebElement email;

	@FindBy(how=How.ID, using = "password")
	public static WebElement password;

	@FindBy(how=How.ID, using = "//button[@class=\"sc-fqkvVR cpKsGa\"]")
	public static WebElement login;
	
	*/
	
	
	public static WebElement enterEmail(WebDriver driver) { 
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement enterPassword(WebDriver driver) { 
		return driver.findElement(By.id("password"));
	}
	
	public static WebElement clickLogin(WebDriver driver) { 
		return driver.findElement(By.xpath("//button[@class='sc-fqkvVR cpKsGa']"));
	}
	
	public static WebElement totalBlogPosts(WebDriver driver) { 
		return driver.findElement(By.xpath("//*[contains(text(),'Total Blog Posts')]"));
	}
	
	public static WebElement forgotPasswordLink(WebDriver driver) { 
		return driver.findElement(By.xpath("//*[contains(text(),'Forgot Password?')]"));
	}

	public static String loginWithValidCredentials(WebDriver driver) throws InterruptedException {
		enterEmail(driver).sendKeys("Admin@gmail.com");
		Thread.sleep(2000);
		enterPassword(driver).sendKeys("Blog@123");
		Thread.sleep(2000);
		clickLogin(driver).click();
		String curTitle = totalBlogPosts(driver).getText();
		return curTitle;
	}
	public static String loginWithInvalidCredentials(WebDriver driver) throws InterruptedException {
		enterEmail(driver).sendKeys("sai@asdfdsafaf.dev");
		Thread.sleep(2000);
		enterPassword(driver).sendKeys("asdfadsfA@1234");
		Thread.sleep(2000);
		clickLogin(driver).click();
		String curTitle = forgotPasswordLink(driver).getText();
		return curTitle;
	}
	public static String loginWithValidMailAndInvalidPassword(WebDriver driver) throws InterruptedException {
		enterEmail(driver).sendKeys("sai@rapidinnovation.dev");
		Thread.sleep(2000);
		enterPassword(driver).sendKeys("asdfadsfA@1234");
		Thread.sleep(2000);
		clickLogin(driver).click();
		String curTitle = forgotPasswordLink(driver).getText();
		return curTitle;
	}
	public static String loginWithInvalidMailAndValidPassword(WebDriver driver) throws InterruptedException {
		enterEmail(driver).sendKeys("sai@asdfafsfs.dev");
		Thread.sleep(2000);
		enterPassword(driver).sendKeys("Blog@1234");
		Thread.sleep(2000);
		clickLogin(driver).click();
		String curTitle = forgotPasswordLink(driver).getText();
		return curTitle;
	}
}
