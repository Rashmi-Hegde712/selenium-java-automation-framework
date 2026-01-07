package com.testproject.uiandapiautomation.APIbase;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;	
import static io.restassured.RestAssured.given;

import com.testproject.uiandapiautomation.models.User;

import io.restassured.http.ContentType;

public class ApiBasePage {

	protected RequestSpecification request() {
        return given()
                .header("Content-Type", "application/json")
                .log().all();
    }

    protected Response get(String endpoint) {
        return request()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

	
	public Response createPost(User user) { 
		  return given()
				  .contentType(ContentType.JSON) 
				  .body(user)
				  .post("https://jsonplaceholder.typicode.com/posts"); 
	}
	 

    protected Response delete(String endpoint) {
        return request()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }	
}
	