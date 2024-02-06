package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class query_param_single_id {

	@Test
	void get_users()
	
	{
		given()
		
		.queryParam("page",2)
		.queryParam("id",5)
		
		.when()
		
		.get("https://reqres.in/api/users")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
