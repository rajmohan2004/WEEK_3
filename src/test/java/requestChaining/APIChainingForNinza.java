package requestChaining;

import java.io.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APIChainingForNinza {
	String project_Id;
@Test
public void createProject()
{
	File jsonBody=new File("./src/test/resources/create_data.json");
	Response response=given().contentType(ContentType.JSON).body(jsonBody)
			
			.when().post("http://49.249.28.218:8091/addProject");
	
	project_Id=response.jsonPath().getString("projectId");
	System.out.println("The Project Id is: "+project_Id);
	
}

@Test(dependsOnMethods="createProject")
public void getProject()
{
	given().pathParam("projectId", project_Id)
	.when().get("http://49.249.28.218:8091/project/{projectId}")
	.then().log().all();
	
}
@Test(dependsOnMethods="getProject")
public void putProject()
{
	File jsonBody=new File("./src/test/resources/update_data.json");
    given().pathParam("projectId",project_Id).contentType(ContentType.JSON).body(jsonBody)
			
			.when().put("http://49.249.28.218:8091/project/{projectId}")
			.then().log().all();
			
}
@Test(dependsOnMethods="putProject")
public void deleteProject()
{
	given().pathParam("projectId", project_Id)
	.when().delete("http://49.249.28.218:8091/project/{projectId}")
	.then().log().all();
}
}
