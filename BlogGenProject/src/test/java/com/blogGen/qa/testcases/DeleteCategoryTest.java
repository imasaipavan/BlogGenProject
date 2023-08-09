package com.blogGen.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.pages.DeleteCategoryPage;

public class DeleteCategoryTest extends Base{
	
	public  WebDriver driver;
	public  BlogLoginPage login;
	public  DeleteCategoryPage deleteCategory;
	
	public DeleteCategoryTest() {
		super();
	}
	
	@Parameters({"browserName","url"})
	@BeforeMethod
	public  void setUp(String browserName, String url) throws IOException {
		driver = launchBrowser(browserName, url);
	}
	
	@AfterMethod
	public  void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, enabled = true)
	public  void deleteACategory() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		deleteCategory.deleteCategroy(driver);
		
	}
	
	@Test(priority = 2, enabled = false)
	public  void deleteACategoryWithoutSelectingCategory() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		deleteCategory.deleteCategoryWithoutSelectingCategory(driver);
		
	}
	
	
	

}
