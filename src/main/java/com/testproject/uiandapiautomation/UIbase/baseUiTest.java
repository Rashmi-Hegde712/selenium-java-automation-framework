package com.testproject.uiandapiautomation.UIbase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.testproject.uiandapiautomation.utils.ConfigFileReader;

public class baseUiTest {

	protected static final Logger logger = LogManager.getLogger(baseUiTest.class);
	protected WebDriver driver;
	public static ExtentReports extentReports;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setupUi(ITestContext context) 
	{
		logger.info("Starting test setup");
		driverFactory.initializeDriver();
		this.driver = driverFactory.getDriver();			
	}
	
	public void navigateUrl() 
	{
		String url = ConfigFileReader.get("ui.url");
		System.out.println(url);
		driver.get(url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driverFactory.quitDriver();
		logger.info("Closing browser");
	}
	
	@AfterSuite
	public void GenerateExtentReports() {
		//extentReports.flush();
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
}
