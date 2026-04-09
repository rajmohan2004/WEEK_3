package crudUsingTestNg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostAMethod {
@Test
public void createProject()
{
	RestAssured.given().contentType(ContentType.JSON).body("{\"createdBy\":\"Raj\","
		    + "\"projectName\":\"ExeProject102\","
		    + "\"status\":\"Ongoing\","
		    + "\"teamSize\":0}")
	
	//HTTP Method
	.when().post("http://49.249.28.218:8091/addProject")
	
	//Response
	.then().statusCode(201).log().all();
}
}
