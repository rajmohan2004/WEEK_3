package crudUsingTestNg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {
@Test
public void updateProject()
{
	RestAssured.given().contentType(ContentType.JSON).body("{\"createdBy\":\"Rajmohan\","
		    + "\"projectName\":\"ExerciseProject201\","
		    + "\"status\":\"Completed\","
		    + "\"teamSize\":0}")
	
	//HTTP Method
	.when().put("http://49.249.28.218:8091/project/NH_PROJ_3242")
	
	//Response
	.then().log().all();
}
}
