package com.testproject.uiandapiautomation.bdd.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testproject.uiandapiautomation.UIbase.driverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    // Only scenarios tagged @ui get a browser (API-only scenarios can skip it later).
    @Before("@ui")
    public void setUp(Scenario scenario) {
        logger.info("Starting scenario: {}", scenario.getName());
        driverFactory.initializeDriver();
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = driverFactory.getDriver();
            if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(shot, "image/png", "Failure screenshot");
            }
        } finally {
            driverFactory.quitDriver();
            logger.info("Finished scenario: {} [{}]", scenario.getName(), scenario.getStatus());
        }
    }
}
