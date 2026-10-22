package com.testproject.uiandapiautomation.bdd.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.testproject.uiandapiautomation.UIbase.driverFactory;
import com.testproject.uiandapiautomation.pages.LoginPage;
import com.testproject.uiandapiautomation.utils.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Cucumber creates a new instance of this class for every scenario,
 * so the loginPage field is safe under parallel execution.
 */
public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the Ultimate QA automation page")
    public void openSite() {
        WebDriver driver = driverFactory.getDriver();
        driver.get(ConfigFileReader.get("ui.url"));
        loginPage = new LoginPage(driver);
    }

    @When("the user opens the login automation page")
    public void openLoginPage() {
        loginPage.clickOnLoginLink();
    }

    @Then("the welcome message {string} is displayed")
    public void verifyWelcome(String expected) {
        Assert.assertEquals(loginPage.verifyLogin(), expected);
    }

    @When("the user signs in with the configured credentials")
    public void signIn() throws Exception {
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickSignIn();
    }

    @Then("the {string} page is displayed")
    public void verifyLanding(String expected) {
        Assert.assertEquals(loginPage.verifyProductsPage(), expected);
    }
}
