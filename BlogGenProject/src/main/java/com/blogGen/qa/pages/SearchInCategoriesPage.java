package com.blogGen.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchInCategoriesPage {
	public WebDriver driver;
	
	public SearchInCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement searchBox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder='Search Category']"));
	}
	
	public static WebElement settingsPage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@alt='Settings-icon']"));
	}
	
	public static WebElement noDataFoundText(WebDriver driver) {
		return driver.findElement(By.xpath("//td/h2"));
	}
	
	public static WebElement firstCategory(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-dhKdcB brFGKm'])[1]"));
	}
	
	public static WebElement clearButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@class='sc-gFAWRd cAYrZA']"));
	}
	
	public static void searchForValidProduct(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		settingsPage(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBox(driver)));
		searchBox(driver).click();
		searchBox(driver).sendKeys("Food");
		wait.until(ExpectedConditions.visibilityOf(firstCategory(driver)));
		String firstBlogText = firstCategory(driver).getText();
		Assert.assertTrue(firstBlogText.contains("Food"));
		
	}
	
	public static void searchForAInvalidProduct(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		settingsPage(driver).click();
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
