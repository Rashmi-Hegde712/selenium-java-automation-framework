package com.testproject.uiandapiautomation.bdd.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG entry point for Cucumber.
 * Do NOT extend baseUiTest here - Hooks.java creates and quits the driver,
 * so extending it would start a second browser per scenario.
 *
 * Filter by tag at run time, e.g.:  -Dcucumber.filter.tags="@smoke"
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.testproject.uiandapiautomation.bdd",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    // Runs scenarios in parallel; thread count comes from data-provider-thread-count in the suite XML.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
