package com.blogGen.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchInBlogsPage {
	
	public WebDriver driver;
	
	public SearchInBlogsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement blogPostPage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@alt='Blog Posts-icon']"));
	}
	public static WebElement searchBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Search Blog']"));
	}
	public static WebElement noDataFoundText(WebDriver driver) {
		return driver.findElement(By.xpath("//td/h2"));
	}
	public static WebElement firstBlog(WebDriver driver) {
		return driver.findElement(By.xpath("(//p)[8]"));
	}
	public static WebElement clearButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='sc-gFAWRd cAYrZA']"));
	}
	
	
	public static void searchForValidProduct(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		blogPostPage(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox(driver)));
		searchBox(driver).click();
		searchBox(driver).sendKeys("AI");
		wait.until(ExpectedConditions.visibilityOf(firstBlog(driver)));
		String firstBlogText = firstBlog(driver).getText();
		Assert.assertTrue(firstBlogText.contains("AI"));
		
	}
	
	public static void searchForAInvalidProduct(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		blogPostPage(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(searchBox(driver)));
		searchBox(driver).click();
		searchBox(driver).sendKeys("asdfasfdfas");
		wait.until(ExpectedConditions.visibilityOf(noDataFoundText(driver)));
		String noDateFoundMessage = noDataFoundText(driver).getText();
		Assert.assertEquals(noDateFoundMessage,"No data found");
		clearButton(driver).click();
		
	}
	
	

}
