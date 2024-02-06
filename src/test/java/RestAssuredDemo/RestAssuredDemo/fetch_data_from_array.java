package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class fetch_data_from_array {

	@Test
	void fectch_data()
	{
	Response res = given()
		      .when()
		      .get("https://reqres.in/api/users?page=2");

		      //convert JSON to string
		      JsonPath j = new JsonPath(res.asString());
		      String email = j.getString("data[1].email");
		      System.out.println(email);

	} 
	
	@Test
	void fectch_data1()
	{
	
		      when()
		      .get("https://reqres.in/api/users?page=2");

		      .then()
		      .statusCode(200)
		      .body("data[0].email",equalTo("lindsay.ferguson@reqres.in"));
		      //.log().all();
	} 
	
	
}
