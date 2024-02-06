package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.when;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Rest_Day2 {
	
	@Test
	void get_users()
	{
		when().get("https://reqres.in/api/users").then().statusCode(200).log().all();
		
	}
	

}
