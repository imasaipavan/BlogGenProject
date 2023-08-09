package com.blogGen.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement totalBlogPostsCount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-gsFSXq hwKyes']/h4)[1]"));
	}
	
	public static WebElement deletedBlogPostsCount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-gsFSXq hwKyes']/h4)[2]"));
	}
	public static WebElement activeCategoriesCount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-gsFSXq hwKyes']/h4)[3]"));
	}
	public static WebElement viewAllButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//a[@href='/blogs'])[2]"));
	}
	public static WebElement viewButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//button[@class='sc-dcJsrY fyrDOf'])[1]"));
	}
	public static WebElement shareIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@title='Share blog']"));
	}
	public static WebElement blogPostsHeading(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-bXCLTC eoLCZF']/h1"));
	}
	public static WebElement backButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Back')]"));
	}
	
	public static void verfiyDashboardPage(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		String totalBlogPosts = totalBlogPostsCount(driver).getText();
		String deletedBlogPosts = deletedBlogPostsCount(driver).getText();
		String activeCategories = activeCategoriesCount(driver).getText();
		System.out.println("Total Blog Posts are = "+totalBlogPosts);
		System.out.println("Total Deleted Blog Posts are = "+deletedBlogPosts);
		System.out.println("Total Active Categories are = "+activeCategories);
		Thread.sleep(2000);
		Assert.assertTrue(viewAllButton(driver).isDisplayed());
		Assert.assertTrue(viewButton(driver).isDisplayed());
		viewButton(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shareIcon(driver)));
		Assert.assertTrue(shareIcon(driver).isDisplayed());
		Thread.sleep(2000);
		backButton(driver).click();
		wait.until(ExpectedConditions.visibilityOf(viewAllButton(driver)));
		viewAllButton(driver).click();
		wait.until(ExpectedConditions.visibilityOf(blogPostsHeading(driver)));
		Assert.assertTrue(blogPostsHeading(driver).isDisplayed());
		
	}
	
	
	

	

}
