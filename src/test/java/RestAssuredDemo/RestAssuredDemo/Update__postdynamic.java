package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import org.testng.ITestContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import org.json.JSONObject;

public class Update__postdynamic {
	public String myId;
	int id;
	
	
	@Test(priority=1)
	public void createData(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("f_name","shivani");
		data.put("l_name","roy");
		data.put("address","delhi,India");
		data.put("emp_code",110);
		data.put("designation","Fashion-designer");
		
		int  userId=
				RestAssured.given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/employee")
			
			
		.then()
				
			.statusCode(201)
			.log().all()
			.extract().jsonPath().get("id");
		//System.out.println(userId);
		context.setAttribute("userId", userId);
		

	}
	
	@Test(priority=2,dependsOnMethods= {"createData"})
	public void updateData(ITestContext context)
	{
		
		JSONObject m_data=new JSONObject();
		m_data.put("f_name","shivani");
		m_data.put("l_name","chaudary");
		m_data.put("emp_code",105);
		m_data.put("address","west_bengal");
		m_data.put("designation","Fashion-designer");
		
		
	int userId=(int) context.getAttribute("userId");
	System.out.println(userId);
	RestAssured.given()
			
			.baseUri("http://localhost:3000/")
			.basePath("employee/"+userId)
			.contentType("application/json")
			.body(m_data.toString())
			
		.when()
			.put()
			
		.then()
			.statusCode(200)
			.log().all();
			
		
	}

}
