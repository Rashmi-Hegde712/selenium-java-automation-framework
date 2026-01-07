package com.testproject.uiandapiautomation.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testproject.uiandapiautomation.UIbase.baseUiTest;
import com.testproject.uiandapiautomation.pages.HomePage;
import com.testproject.uiandapiautomation.utils.ExtentLogger;

public class selectButtons extends baseUiTest {
	
	protected static final Logger logger = LogManager.getLogger(selectButtons.class);

	@Test(alwaysRun = true)	
	public void VerifyBtnSelectionPage() throws Exception
	{
		logger.info("selectButtons test started");
		ExtentLogger.log(Status.INFO, "selectButtons test started");
		HomePage homePage = new HomePage(driver);
		navigateUrl();
		
		homePage.clickOnBadgeWithElements();
		String btnStr = homePage.fetchBtnsPageString();
		Assert.assertEquals(btnStr, "Section of Buttons");		
		ExtentLogger.log(Status.PASS, "Assertion passed for select button test");
	}
}