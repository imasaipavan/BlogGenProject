package com.blogGen.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.blogGen.qa.pages.DashboardPage;
import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.utils.VideoRecorder_utlity;

public class DashboardTest extends Base{

	public WebDriver driver;
	public BlogLoginPage login;
	public DashboardPage dashboard;

	public DashboardTest() {
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
		VideoRecorder_utlity.stopRecord();
	}

	@Test
	public void verifyDashboardPage() throws InterruptedException {
		login.loginWithValidCredentials(driver);
		dashboard.verfiyDashboardPage(driver); 
	}

}
