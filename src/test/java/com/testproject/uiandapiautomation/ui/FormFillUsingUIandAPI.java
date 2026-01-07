package com.testproject.uiandapiautomation.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.testproject.uiandapiautomation.APIbase.ApiBasePage;
import com.testproject.uiandapiautomation.UIbase.baseUiTest;
import com.testproject.uiandapiautomation.models.User;
import com.testproject.uiandapiautomation.pages.FillOutFormsPage;
import com.testproject.uiandapiautomation.utils.ExtentLogger;
import com.testproject.uiandapiautomation.utils.JsonUtils;

import io.restassured.response.Response;

public class FormFillUsingUIandAPI extends baseUiTest {

	protected static final Logger logger = LogManager.getLogger(FormFillUsingUIandAPI.class);
	
	@Test
	public void fillFormUsingJson() {
		
		logger.info("fillFormUsingJson test started");
		ExtentLogger.log(Status.INFO, "FillFormUsingJson test started");
		String jsonFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testdata\\formdata.json";
		JsonNode json = JsonUtils.readJsonFile(jsonFilePath);
			
	    for (JsonNode node : json.get("formData")) {
	        
	    	navigateUrl();
	    	
	        String name = node.get("name").asText();
	        String message = node.get("message").asText();
	
	        //Send input data to UI
	        FillOutFormsPage form = new FillOutFormsPage(driver);
	
	        form.clickOnFormLink();
	        form.enterName(name);
	        form.enterText(message);
	        form.submit();
	        
	        String confirmMsg = form.confirmSubmission();
	        Assert.assertEquals(confirmMsg, "Thanks for contacting us");
	        logger.info("Form submitted successfully");
	        ExtentLogger.log(Status.PASS, "Form submitted successfully, hence Test Passed");
	        	        
	        //send same data to API
	        ApiBasePage api = new ApiBasePage();
	        User user = new User(name, message, 1);
	        Response response = api.createPost(user);

	        String responseBody = response.getBody().asString();
	        System.out.println(responseBody);
	        
	        // 4. Validate API response
	        response.then().statusCode(201);
	        Assert.assertEquals(response.path("title"), name);
	        Assert.assertEquals(response.path("body"), message);
	        ExtentLogger.log(Status.INFO, responseBody);
	        ExtentLogger.log(Status.PASS, "Assertion passed for API data check");	        	      
	    }
	}
}