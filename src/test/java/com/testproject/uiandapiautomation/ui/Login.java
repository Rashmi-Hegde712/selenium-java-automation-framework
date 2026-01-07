package com.testproject.uiandapiautomation.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testproject.uiandapiautomation.UIbase.baseUiTest;
import com.testproject.uiandapiautomation.pages.LoginPage;
import com.testproject.uiandapiautomation.utils.ExtentLogger;
import com.testproject.uiandapiautomation.utils.ExtentTestManager;

import listeners.TestListener;

@Listeners(TestListener.class)
public class Login extends baseUiTest {
	
	protected static final Logger logger = LogManager.getLogger(Login.class);

	@Test(alwaysRun = true)
	public void VerifyLogin() throws Exception
	{
		System.out.println("Test thread: " + Thread.currentThread().getId());
	    System.out.println("ExtentTest in test: " + ExtentTestManager.getTest());
	    ExtentLogger.log(Status.INFO, "Starting login test");
		logger.info("Login test started");
		LoginPage loginPage = new LoginPage(driver);
				
		navigateUrl();
		loginPage.clickOnLoginLink();
		String welcomeStr = loginPage.verifyLogin();
		Assert.assertEquals(welcomeStr, "Welcome!");
		
		loginPage.enterEmail();
		loginPage.enterPassword();
		loginPage.clickSignIn();
		String PrdPage = loginPage.verifyProductsPage();
		Assert.assertEquals(PrdPage, "Products");
		ExtentLogger.log(Status.PASS, "Assertion is passed for login page");
	}	
}