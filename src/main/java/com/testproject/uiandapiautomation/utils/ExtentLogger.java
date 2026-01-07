package com.testproject.uiandapiautomation.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentLogger {

	public static void log(Status status, String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.log(status, message);
        }
    }
}
