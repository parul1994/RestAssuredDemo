package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Rest_Day1 {
	
	@Test
	void rest_method1()
	{
	//when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	
	when()
	.get("https://reqres.in/api/users/2")
	
	.then()
		.statusCode(200)
		.log().all();
	
	}
	
	@Test
	void rest_method2()
	{
	
	
	when()
	.get("https://reqres.in/api/users")
	
	.then()
		.statusCode(200)
		.log().all();
	
	}
}
