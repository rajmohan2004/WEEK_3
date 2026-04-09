package ninzaTestNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Project {

	String project_Id;
	
	@Test
	public void addProject()
	{
		System.out.println("POST");
		Response res=given().contentType(ContentType.JSON).body("{\r\n"
				+ "			  \"createdBy\": \"Raj\",\r\n"
				+ "			  \"projectName\": \"TestNgProject01\",\r\n"
				+ "			  \"status\": \"Ongoing\",\r\n"
				+ "			  \"teamSize\": 0\r\n"
				+ "			}")
		
		.when().post("http://49.249.28.218:8091/addProject");
        
		 Assert.assertEquals(res.getStatusCode(), 201);
		 res.then().time(lessThan(5000L));

	     String projectName = res.jsonPath().get("projectName");
	     String status = res.jsonPath().get("status");
	     Assert.assertEquals(projectName, "TestNgProject01");   
	     Assert.assertEquals(status, "Ongoing");
	        
	     project_Id=res.jsonPath().getString("projectId");

	     System.out.println("All Assertions passed");
		
	}
	
	@Test(dependsOnMethods="addProject")
	public void getProject()
	{
		System.out.println("\nGET");
		
		Response res=given().pathParam("projectId", project_Id)
		.when().get("http://49.249.28.218:8091/project/{projectId}");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		res.then().time(lessThan(5000L));
 
	    String projectName = res.jsonPath().get("projectName");
	    String status = res.jsonPath().get("status");
	    Assert.assertEquals(projectName, "TestNgProject01");   
	    Assert.assertEquals(status, "Ongoing");

	    System.out.println("All Assertions passed");
	}
	
	@Test(dependsOnMethods="getProject")
	public void putProject()
	{
		System.out.println("\nPUT");
		
		File jsonBody=new File("./src/test/resources/update_data.json");
	    Response res=given().pathParam("projectId",project_Id).contentType(ContentType.JSON).body(jsonBody)
				
				.when().put("http://49.249.28.218:8091/project/{projectId}");
	    
	    Assert.assertEquals(res.getStatusCode(), 200);
	    res.then().time(lessThan(5000L));
	    
	    String projectName = res.jsonPath().get("projectName");
        String status = res.jsonPath().get("status");
        Assert.assertEquals(projectName, "ProjexeUpdatedTestNG");   
        Assert.assertEquals(status, "Completed");

        System.out.println("All Assretions passed");
				
				
	}
	@Test(dependsOnMethods="putProject")
	public void deleteProject()
	{
		System.out.println("\nDELETE");
		
		Response res=given().pathParam("projectId", project_Id)
		.when().delete("http://49.249.28.218:8091/project/{projectId}");
		
		Assert.assertEquals(res.getStatusCode(), 204);
	    res.then().time(lessThan(5000L));
	    
	    System.out.println("All Assretions passed\n");
	}
}
