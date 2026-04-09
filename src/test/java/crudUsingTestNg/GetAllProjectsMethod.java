package crudUsingTestNg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllProjectsMethod {
	@Test
	public void getAllProjects()
	{
		RestAssured.given()
	    
		
		
		//HTTP Method
		.when()
		.get("http://49.249.28.218:8091/projects")
		
		
		//Response
		.then().statusCode(200)
		.log()
		.all();
	}
}
