package com.blogGen.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfileEditPage {
	WebDriver driver;

	public ProfileEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static WebElement profileIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='sc-iGgWBj sc-tagGq bJGYPX gjauNE equal']"));
	}

	public static WebElement viewProfile(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'View profile')]"));
	}

	public static WebElement firstName(WebDriver driver) {
		return driver.findElement(By.id("firstName"));
	}

	public static WebElement lastName(WebDriver driver) {
		return driver.findElement(By.id("lastName"));
	}

	public static WebElement mobileNumber(WebDriver driver) {
		return driver.findElement(By.id("phoneNumber"));
	}

	public static WebElement address(WebDriver driver) {
		return driver.findElement(By.id("address"));
	}

	public static WebElement state(WebDriver driver) {
		return driver.findElement(By.id("state"));
	}

	public static WebElement country(WebDriver driver) {
		return driver.findElement(By.id("country"));
	}

	public static WebElement personalDetails(WebDriver driver) {
		return driver.findElement(By.id("personalDetails"));
	}

	public static WebElement submit(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-fqkvVR jXIpWA']"));
	}

	public static WebElement confirm(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='sc-fqkvVR hughWF']"));
	}

	public static WebElement successPopup(WebDriver driver) {
		return driver.findElement(By.xpath("(//p)[6]"));
	}

	public static WebElement closeButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='sc-bmzYkS fcHBP'])[1]"));
	}
	
	public static WebElement firstNameRequiredAlert(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='sc-imWYAI fjafn'])[1]"));
	}
	
	public static WebElement lastNameRequiredAlert(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[@class='sc-imWYAI fjafn'])[2]"));
	}
	
	public static WebElement personalDetailsWarningAlert(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'personalDetails must be shorter than or equal to 500 characters')]"));
	}
	
	public static WebElement firstNameWarningAlert(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'First Name must be shorter than or equal to 30 characters')]"));
	}
	
	public static WebElement lastNameWarningAlert(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Last Name must be shorter than or equal to 30 characters')]"));
	}
	
	public static WebElement mobileNumberWarningAlert(WebDriver driver) {
		return driver.findElement(By.xpath("//*[contains(text(),'Phone number must be shorter than or equal to 15 characters')]"));
	}
	
	
	public static String editProfileDetails(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		profileIcon(driver).click();
		Thread.sleep(2000);
		viewProfile(driver).click();
		Thread.sleep(2000);
		firstName(driver).sendKeys(Keys.COMMAND+"a");
		firstName(driver).sendKeys("SAI");
		Thread.sleep(2000);
		lastName(driver).sendKeys(Keys.COMMAND+"a");
		lastName(driver).sendKeys("PAVAN");
		Thread.sleep(2000);
		mobileNumber(driver).sendKeys(Keys.COMMAND+"a");
		mobileNumber(driver).sendKeys("98765434445");
		Thread.sleep(2000);
		address(driver).sendKeys(Keys.COMMAND+"a");
		address(driver).sendKeys("GANESH NAGAR, GIDDALUR");
		Thread.sleep(2000);
		state(driver).sendKeys(Keys.COMMAND+"a");
		state(driver).sendKeys("ANDHRA PRADESH");
		Thread.sleep(2000);
		country(driver).sendKeys(Keys.COMMAND+"a");
		country(driver).sendKeys("INDIA");
		Thread.sleep(2000);
		long time= System.currentTimeMillis();
		personalDetails(driver).sendKeys(Keys.COMMAND+"a");
		personalDetails(driver).sendKeys("This is description"+time);
		Thread.sleep(2000);
		submit(driver).click();
		Thread.sleep(2000);
		confirm(driver).click();
		Thread.sleep(2000);
		String successMessage = driver.findElement(By.xpath("(//p)[6]")).getText();
		return successMessage;
	}
	
	public static void editProfileDetailsWithoutEnteringAnything(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		profileIcon(driver).click();
		Thread.sleep(2000);
		viewProfile(driver).click();
		Thread.sleep(2000);
		Boolean bolValue = submit(driver).isEnabled();
		Assert.assertFalse(bolValue);
	}
	
	public static void editProfileDetailsByPuttingEverythingAsBlank(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		profileIcon(driver).click();
		Thread.sleep(2000);
		viewProfile(driver).click();
		Thread.sleep(2000);
		firstName(driver).sendKeys(Keys.COMMAND+"a");
		firstName(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		lastName(driver).sendKeys(Keys.COMMAND+"a");
		lastName(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		mobileNumber(driver).sendKeys(Keys.COMMAND+"a");
		mobileNumber(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		address(driver).sendKeys(Keys.COMMAND+"a");
		address(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		state(driver).sendKeys(Keys.COMMAND+"a");
		state(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		country(driver).sendKeys(Keys.COMMAND+"a");
		country(driver).sendKeys("INDIA");
		Thread.sleep(2000);
		personalDetails(driver).sendKeys(Keys.COMMAND+"a");
		personalDetails(driver).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		submit(driver).click();
		Assert.assertTrue(firstNameRequiredAlert(driver).isDisplayed());
		Assert.assertTrue(lastNameRequiredAlert(driver).isDisplayed());
	}
	
	public static void editProfileDataByEnteringMorethanMaxChars(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		profileIcon(driver).click();
		Thread.sleep(2000);
		viewProfile(driver).click();
		Thread.sleep(2000);
		firstName(driver).sendKeys(Keys.COMMAND+"a");
		firstName(driver).sendKeys("SAIasfdsafasfsdfasfsadfaffasfaf");
		Thread.sleep(2000);
		lastName(driver).sendKeys(Keys.COMMAND+"a");
		lastName(driver).sendKeys("SAIasfdsafasfsdfasfsadfaffasfaf");
		Thread.sleep(2000);
		mobileNumber(driver).sendKeys(Keys.COMMAND+"a");
		mobileNumber(driver).sendKeys("987654344452342344");
		Thread.sleep(2000);
		address(driver).sendKeys(Keys.COMMAND+"a");
		address(driver).sendKeys("GANESH NAGAR, GIDDALUR");
		Thread.sleep(2000);
		state(driver).sendKeys(Keys.COMMAND+"a");
		state(driver).sendKeys("ANDHRA PRADESH");
		Thread.sleep(2000);
		country(driver).sendKeys(Keys.COMMAND+"a");
		country(driver).sendKeys("INDIA");
		Thread.sleep(2000);
		long time= System.currentTimeMillis();
		personalDetails(driver).sendKeys(Keys.COMMAND+"a");
		personalDetails(driver).sendKeys("nothingadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadmin"
				+ "adminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminnothing adminadminadminadminadminadmina"
				+ "dminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminad"
				+ "minsaddsa");
		Thread.sleep(2000);
		submit(driver).click();
//		String firstNameWarningMessage = firstNameWarningAlert(driver).getText();
//		String lastNameWarningMessage = lastNameWarningAlert(driver).getText();
//		String mobileNumberWarningMessage = mobileNumberWarningAlert(driver).getText();
//		String personalDetailsWarningMessage = personalDetailsWarningAlert(driver).getText();
		Assert.assertTrue(firstNameWarningAlert(driver).isDisplayed());
		Assert.assertTrue(lastNameWarningAlert(driver).isDisplayed());
		Assert.assertTrue(mobileNumberWarningAlert(driver).isDisplayed());
		Assert.assertTrue(personalDetailsWarningAlert(driver).isDisplayed());
		
	}
	
	}
	

