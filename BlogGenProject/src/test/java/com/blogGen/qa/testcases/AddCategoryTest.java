package com.blogGen.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.AddCategoryPage;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.utils.VideoRecorder_utlity;

public class AddCategoryTest extends Base{
	public WebDriver driver;
	public BlogLoginPage login;
	public AddCategoryPage AddCategory;

	public AddCategoryTest() {
		super();
	}

	@Parameters({"browserName", "url"})
	@BeforeMethod
	public void setUp(String browerName, String url) throws IOException {
		driver = launchBrowser(browerName, url);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
//		VideoRecorder_utlity.stopRecord();
	}

	@Test(priority = 1, enabled = true)
	public void addNewCatergoryWithAllDetails() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		AddCategory.addNewCategoryWithAllDetails(driver); 
	}
	@Test(priority = 2, enabled = true)
	public void addNewCategoryWithoutEnteringAnthing() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		AddCategory.addNewCategoryWithoutEnteringAnthing(driver); 
	}
	@Test(priority = 3, enabled = true)
	public void addNewCategoryByEnteringOnlyName() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		AddCategory.addNewCategoryByEnteringOnlyName(driver); 
	}
	@Test(priority = 4, enabled = true)
	public void addNewCategoryByPuttingOnlyDate() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		AddCategory.addNewCategoryByPuttingOnlyDate(driver); 
	}
	@Test(priority = 5, enabled = true)
	public void addNewCategoryByPuttingOnlyFrequency() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		AddCategory.addNewCategoryByEnteringOnlyName(driver); 
	}
}
