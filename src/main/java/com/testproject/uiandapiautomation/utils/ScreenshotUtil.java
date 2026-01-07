package com.testproject.uiandapiautomation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.testproject.uiandapiautomation.UIbase.driverFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	    public static String takeScreenshot(String testName) {

	    	WebDriver driver = driverFactory.getDriver();
	    	 
	        String timestamp =
	                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        String screenshotPath =
	                "screenshots/" + testName + "_" + timestamp + ".png";
	        
	        File srcFile =
	                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        File destFile = new File(screenshotPath);

	        try {
	            Files.createDirectories(destFile.getParentFile().toPath());
	            Files.copy(srcFile.toPath(), destFile.toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return screenshotPath;
	    }
}
