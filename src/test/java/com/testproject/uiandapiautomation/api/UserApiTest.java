package com.testproject.uiandapiautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.testproject.uiandapiautomation.APIbase.ApiBasePage;
import com.testproject.uiandapiautomation.models.User;
import com.testproject.uiandapiautomation.utils.JsonUtils;

import io.restassured.response.Response;

public class UserApiTest extends ApiBasePage {

	@Test
    public void createUserTest() {

		String jsonFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testdata\\formdata.json";
		JsonNode json = JsonUtils.readJsonFile(jsonFilePath);
			
	    for (JsonNode node : json.get("formData")) {
	        
	    	String name = node.get("name").asText();
	        String message = node.get("message").asText();
		 
	        ApiBasePage api = new ApiBasePage();
	        User user = new User(name, message, 1);
	        Response response = api.createPost(user);
	
	        // 4. Validate API response
	        response.then().statusCode(201);
	        Assert.assertEquals(response.path("title"), name);
	        Assert.assertEquals(response.path("body"), message);
	    }
	}
		
}