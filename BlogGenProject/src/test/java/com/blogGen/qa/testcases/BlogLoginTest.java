package com.blogGen.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.utils.VideoRecorder_utlity;

public class BlogLoginTest extends Base{
	public WebDriver driver;
	public BlogLoginPage login;
	
	public BlogLoginTest() {
		super();
	}
	
	@Parameters({"browserName","url"})
	@BeforeMethod 
	public void setup(String browserName, String url) throws Exception {
		driver = launchBrowser(browserName,url); 
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		VideoRecorder_utlity.stopRecord();
	}
	
	@Test(priority = 1, enabled = true)
	public void loginWithValidMailAndPassword() throws Exception {
		VideoRecorder_utlity.startRecord("Login with Valid Credentials");
		 String expTitle = login.loginWithValidCredentials(driver);
		Assert.assertEquals(expTitle, "Total Blog Posts");
	}
	
	@Test(priority = 2, enabled = true)
	public void loginWithInvalidMailAndInvalidPassword() throws Exception {
		VideoRecorder_utlity.startRecord("Login with Invalid Credentials");
		 String expTitle = login.loginWithInvalidCredentials(driver);
		Assert.assertEquals(expTitle, "Forgot Password?");
	}
	
	@Test(priority = 3, enabled = true)
	public void loginWithValidMailInvalidPassword() throws Exception {
		VideoRecorder_utlity.startRecord("Login with Valid Main & Invalid Password");
		 String expTitle = login.loginWithValidMailAndInvalidPassword(driver);
		Assert.assertEquals(expTitle, "Forgot Password?");
	}
	
	@Test(priority = 4, enabled = true)
	public void loginWithInvalidMailValidPassword() throws Exception {
		VideoRecorder_utlity.startRecord("Login with Invalid Main & Valid password");
		 String expTitle = login.loginWithInvalidMailAndValidPassword(driver);
		Assert.assertEquals(expTitle, "Forgot Password?");
	}

}
