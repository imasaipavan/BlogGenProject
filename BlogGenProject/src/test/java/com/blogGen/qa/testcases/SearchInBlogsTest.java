package com.blogGen.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.pages.SearchInBlogsPage;
import com.blogGen.qa.utils.VideoRecorder_utlity;

public class SearchInBlogsTest extends Base{
	public WebDriver driver;
	public BlogLoginPage login;
	public SearchInBlogsPage search;
	
	@Parameters({"browserName","url"})
	@BeforeMethod
	public void setUp(String browserName, String url) throws IOException {
		driver = launchBrowser(browserName, url);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		VideoRecorder_utlity.stopRecord();
	}
	
	@Test(priority = 1, enabled = true)
	public void searchForValidBlog() throws Exception {
		VideoRecorder_utlity.startRecord("Search for a valid blog");
		login.loginWithValidCredentials(driver);
		search.searchForValidProduct(driver);
		
	}
	@Test(priority = 2, enabled = true)
	public void searchForInvalidBlog() throws Exception {
		VideoRecorder_utlity.startRecord("Search for a invalid blog");
		login.loginWithValidCredentials(driver);
		search.searchForAInvalidProduct(driver);
		
	}

}
