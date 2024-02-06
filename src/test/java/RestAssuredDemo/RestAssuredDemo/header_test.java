package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class header_test {
	
	@Test
	void get_header_onebyone()
	
	{
		Response header_1=given()
	
		.when()
		
		.get("https://github.com/");
		
		String header_ser=header_1.getHeader("Server");
		String header_Content=header_1.getHeader("Content-Type");
		String header_vary=header_1.getHeader("Vary");
		System.out.println("printing server name -> "+header_ser);
		System.out.println("printing content-type -> "+header_Content);
		System.out.println("printing header vary -> "+header_vary);
		
		
		
	}
	
	@Test(priority=2)
	void get_detailed_header()
	{
		Headers  allheaders = get("https://github.com/").getHeaders();
		List<Header> myheaders = allheaders.getList("X-XSS-Protection");
		
		for(Header i: myheaders)
		{
		
		System.out.println("printing headers -> "+i);
		}
	}
	
	@Test(priority=3)
	void get_multiple_headers_details()
	{
	
		Response headers_details=when().get("https://github.com/");
		Headers allHeaders = headers_details.getHeaders();
		
		for(Header key:allHeaders)
		{
			System.out.println("Headers name -> "+key.getName()+" : "+"Headers value -> "+key.getValue());
		}
	}


}
