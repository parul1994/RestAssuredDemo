package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import org.json.JSONObject;

public class Post_data {
	
	
	
	
	
	@Test(priority=1)
	public void Post_request()
	{
		JSONObject param=new JSONObject();
		param.put("name", "parul");
		param.put("job", "Testing");
		
	given()
		.contentType("application/json")
		.body(param.toString())
		
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.log().all()
			.extract().jsonPath().get("id");
			
	
		
	}
	
	
	@Test(priority=1)
	public void delete()
	{
		
		when()
			.delete("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	

	
	
}
