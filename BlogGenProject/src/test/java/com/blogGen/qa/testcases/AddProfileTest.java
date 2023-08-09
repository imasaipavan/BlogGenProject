package com.blogGen.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.AddProfilePage;
import com.blogGen.qa.pages.BlogLoginPage;

public class AddProfileTest extends Base {
	public WebDriver driver;
	public AddProfilePage addProfile;
	public BlogLoginPage login;


	public AddProfileTest() {
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
	public  void addNewUser() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		addProfile.addNewUser(driver);
	}
	
	
	@Test(priority = 2, enabled = true)
	public  void addNewUserWithoutEnteringEmail() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		addProfile.addNewUserWithoutEnteringEmail(driver);
	}
}
