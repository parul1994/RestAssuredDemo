package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.ITestContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


public class parameter_pass {
	
	public int stu_id;
	
	@Test(priority=1)
	public void fetch_data()
	{
				
		when()
		.get("http://localhost:3000/employee")
		
		.then()
		
		.statusCode(200)
		.log().all();
		
	}
	
	
	
	@Test(priority=2,dependsOnMethods= {"fetch_data"})
	public void post_data(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("f_name","shivani");
		data.put("l_name","roy");
		data.put("address","delhi,India");
		data.put("emp_code",110);
		data.put("designation","Fashion-designer");
		
		 stu_id=
				given()
				.contentType("application/json")
				.body(data.toString())
				
				.when()
					.post("http://localhost:3000/employee/")
					
				.then()
					.statusCode(201)
					.log().all()
					.extract().jsonPath().get("id");	
		 System.out.println(stu_id);
		 context.setAttribute("stu_id", stu_id);
	
	}
	
	@Test(priority=3,dependsOnMethods= {"post_data"})
	public void update_data(ITestContext context)
	{
		JSONObject m_data=new JSONObject();
		m_data.put("f_name","shivani");
		m_data.put("l_name","chaudary");
		m_data.put("emp_code",105);
		m_data.put("address","west_bengal");
		m_data.put("designation","Fashion-designer");
		
		
		 stu_id= (int) context.getAttribute("stu_id");
		given()
			.contentType("application/json")
			.body(m_data.toString())
			
			
		
		.when()
			.put("http://localhost:3000/employee/"+stu_id)
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=4,dependsOnMethods= {"post_data"})
	public void delete_data(ITestContext context)
	{
		
		
		// JSONObject data=new JSONObject();
			//System.out.println(data.put("id",stu_id));
			
			stu_id= (int) context.getAttribute("stu_id");
			// System.out.println(stu_id);
		/* given()
		 	.contentType("application/json")
		 	.body(data.toString())
		 */
		
		when()
			.delete("http://localhost:3000/employee/"+stu_id)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	


}
