package crudUsingTestNg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAMethod {
@Test
public void getProject()
{
	RestAssured.given()
    
	
	
	//HTTP Method
	.when()
	.get("http://49.249.28.218:8091/project/NH_PROJ_3242")
	
	
	//Response
	.then().statusCode(200)
	.log()
	.all();
}
}
