package com.blogGen.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blogGen.qa.base.Base;
import com.blogGen.qa.pages.BlogLoginPage;
import com.blogGen.qa.pages.ProfileEditPage;
import com.blogGen.qa.utils.VideoRecorder_utlity;

public class ProfileEditTest extends Base {
	
	public WebDriver driver;
	public BlogLoginPage login;
	public ProfileEditPage profileEdit;
	
	
	public ProfileEditTest() {
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
	public void editUserProfileWithAllFields() throws Exception {
		VideoRecorder_utlity.startRecord("Edit Profile Details Of All Fields");
		login.loginWithValidCredentials(driver);
		 String expTitle = profileEdit.editProfileDetails(driver);
		Assert.assertEquals(expTitle, "Profile updated successfully.");
		
	}
	
	@Test(priority = 2, enabled = true)
	public void editProfileWithoutEnteringAnything() throws Exception {
		VideoRecorder_utlity.startRecord("Edit Profile Details Without Entering Anything");
		login.loginWithValidCredentials(driver);
		profileEdit.editProfileDetailsWithoutEnteringAnything(driver);
	}
	
	@Test(priority = 3, enabled = true)
	public void editProfileByPuttingBlankInAllMandatoryFields() throws Exception {
		VideoRecorder_utlity.startRecord("Edit Profile Details By Putting");
		login.loginWithValidCredentials(driver);
		profileEdit.editProfileDetailsByPuttingEverythingAsBlank(driver);
	}
}
