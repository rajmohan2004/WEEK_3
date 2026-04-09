package crudUsingTestNg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethod {
	@Test
	public void deleteProject()
	{
	RestAssured.given()
	
	//HTTP Method
	.when().delete("http://49.249.28.218:8091/project/NH_PROJ_3242")
	
	//Response
	.then().log().all();
}
}