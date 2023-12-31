package com.blogGen.qa.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.blogGen.qa.utils.ExtentReporter;
import com.blogGen.qa.utils.Utilities;

public class MyListeners implements ITestListener{
	ExtentTest test;
	String testName ;
	ExtentReports extent = ExtentReporter.generateExtentReport();

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		test = extent.createTest(testName);
		test.log(Status.INFO, testName+ " Started Executing");
		System.out.println(testName+ " Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, testName+ " got Successfully executed");
		System.out.println(testName+ " got Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver =null;
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{

		}
		String dest = Utilities.generateScreenshot(testName,driver);
		test.addScreenCaptureFromPath(dest);
		test.log(Status.FAIL, testName+ " got Successfully executed");
		System.out.println(testName+ " got failed and screenshot taken");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started");
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, testName+ " got skipped");
		System.out.println(testName+ " got Skipped");
		System.out.println(result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
