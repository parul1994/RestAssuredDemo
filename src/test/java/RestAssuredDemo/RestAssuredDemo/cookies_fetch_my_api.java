package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class cookies_fetch_my_api {
	
	@Test(priority=1)
	void path_query()
	{
		
		given()
		 .pathParam("resourcePath", "employee")
		
		.queryParam("employee",1)
		.queryParam("id",3)
		
		.when()
		.get("http://localhost:3000/{resourcePath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority=2)
	void cookies_fetch()
	{
	
	Response res=given()
	.when()
	.get("https://www.amazon.in/");
	
	String cookie=res.getCookie("session-id");
	System.out.println(cookie);
	
	
	}
	
	@Test(priority=3)
	void multiple_cookies()
	{
		Response res=when().get("https://www.amazon.in/");
		Map<String,String> mycookies=res.getCookies();
		for(String key: mycookies.keySet())
		{
			System.out.println("Cookies name -> "+key);
		}	
		
	}
	
	@Test(priority=4)
	void header_fetch()
	{
		Response res=given()
			.when()
			.get("https://www.amazon.in/");
		
		String header=res.getHeader("Content-Type");
		System.out.println("content of header is - > "+header);
	}
	
	@Test(priority=5)
	void multiple_header()
	{
		Response res=when().get("https://www.amazon.in/");
		Headers allheader=res.getHeaders();
		
		for(Header key:allheader)
		{
			System.out.println("Headers name -> "+key);
		}
	}
	
	

}
