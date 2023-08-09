package com.blogGen.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCategoryPage {
	public WebDriver driver;
	public static String dateAndTime = "11/08/23";

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static WebElement settingsPage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@alt='Settings-icon']"));
	}

	public static WebElement addCategory(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-iGgWBj bJGYPX'])[2]"));
	}

	public static WebElement categoryName(WebDriver driver) {
		return driver.findElement(By.id("name"));
	}
	public static WebElement frequencyDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-iGgWBj sc-fBWQRz bJGYPX hOqBvj']"));
	}
	//	public static WebElement selectDate(WebDriver driver) {
	//		return driver.findElement(By.xpath("//input[@name='scheduledTime']"));
	//	}

	public static WebElement setDateYear(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='scheduledTime']"));
	}

	public static WebElement submitButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-fqkvVR gykksy']"));
	}
	public static WebElement closeFrequencyDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@alt='chevron icon'])[2]"));
	}
	
	public static WebElement categoryAddedMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Category added successfully.')]"));
	}
	
	public static WebElement closeIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@alt='close icon']"));
	}
	
	public static WebElement selectDailyFrequency(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-jMakVo dRqIyI'])[1]"));
	}
	
	public static WebElement selectHourlyFrequency(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-jMakVo dRqIyI'])[2]"));
	}
	public static WebElement selectWeeklyFrequency(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-jMakVo dRqIyI'])[3]"));
	}
	public static WebElement selectMonthlyFrequency(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-jMakVo dRqIyI'])[4]"));
	}
	
	public static WebElement searchNewlyAddedCategory(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@placeholder='Search Category']"));
	}
	
	public static WebElement newlyAddedCategoryName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-dhKdcB brFGKm']"));
	}
	
	
	

	public static void addNewCategoryWithAllDetails(WebDriver driver) throws InterruptedException {
		settingsPage(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addCategory(driver)));
		addCategory(driver).click();
		Thread.sleep(2000);
		long time = System.currentTimeMillis();
		categoryName(driver).sendKeys("Personal"+time);
		Thread.sleep(2000);
		setDateYear(driver).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		setDateYear(driver).sendKeys(dateAndTime);
		Thread.sleep(2000);
		frequencyDropdown(driver).click();
		Thread.sleep(2000);
		selectDailyFrequency(driver).click();
		Thread.sleep(3000);
		closeFrequencyDropdown(driver).click();
		Thread.sleep(2000);
		submitButton(driver).click();
		Thread.sleep(2000);
		Assert.assertTrue(categoryAddedMessage(driver).isDisplayed());
		closeIcon(driver).click();
		Thread.sleep(4000);
		searchNewlyAddedCategory(driver).sendKeys("Personal"+time);
		String newCategoryName = "Personal"+time;
		String expCategoryName = newlyAddedCategoryName(driver).getText();
		Assert.assertEquals(newCategoryName,expCategoryName);

	}
	
	public static void addNewCategoryWithoutEnteringAnthing(WebDriver driver) throws InterruptedException {
		settingsPage(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addCategory(driver)));
		addCategory(driver).click();
		Thread.sleep(2000);
		Assert.assertFalse(submitButton(driver).isEnabled());
	}
	
	public static void addNewCategoryByEnteringOnlyName(WebDriver driver) throws InterruptedException {
		settingsPage(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addCategory(driver)));
		addCategory(driver).click();
		Thread.sleep(2000);
		categoryName(driver).sendKeys("ABCDEF");
		Thread.sleep(2000);
		Assert.assertFalse(submitButton(driver).isEnabled());
	}
	public static void addNewCategoryByPuttingOnlyDate(WebDriver driver) throws InterruptedException {
		settingsPage(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addCategory(driver)));
		addCategory(driver).click();
		Thread.sleep(2000);
		setDateYear(driver).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		setDateYear(driver).sendKeys(dateAndTime);
		Thread.sleep(2000);
		Assert.assertFalse(submitButton(driver).isEnabled());
	}
	
	public static void addNewCategoryByPuttingOnlyFrequency(WebDriver driver) throws InterruptedException {
		settingsPage(driver).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addCategory(driver)));
		addCategory(driver).click();
		Thread.sleep(2000);
		frequencyDropdown(driver).click();
		Thread.sleep(2000);
		selectDailyFrequency(driver).click();
		Thread.sleep(3000);
		closeFrequencyDropdown(driver).click();
		Thread.sleep(2000);
		Assert.assertFalse(submitButton(driver).isEnabled());
	}
	
	}

