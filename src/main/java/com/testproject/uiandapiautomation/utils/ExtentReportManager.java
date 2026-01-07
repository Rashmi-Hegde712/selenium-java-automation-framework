package com.testproject.uiandapiautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testproject.uiandapiautomation.UIbase.baseUiTest;

public class ExtentReportManager extends baseUiTest {

	public static synchronized ExtentReports getExtent() {
        if (extentReports == null) {
            ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/AllTests.html");

            extentReports = new ExtentReports();
            extentReports.attachReporter(spark);
            extentReports.setSystemInfo("Browser", ConfigFileReader.get("browser"));
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
            
        }
        return extentReports;
    }
}
