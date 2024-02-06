package RestAssuredDemo.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.hasValue;

import org.testng.annotations.Test;

public class cookies_value {

	@Test(priority=1)
	void get_cookie()
	
	{
		Response cookie_var=given()
	
		.when()
		
		.get("https://github.com/");
		
		String cookie=cookie_var.getCookie("_gh_sess");
		System.out.println(cookie);
		
	}
	
	
	
	
	@Test(priority=2)
	void get_detailed_cookies()
	{
		Cookies allDetailedCookies = get("https://github.com/").getDetailedCookies();
		List<Cookie> myCookies = allDetailedCookies.getList("_octo");
		//List<String> myCookies = allDetailedCookies.getValues("_octo");
		for(Cookie i: myCookies)
		{
		
		System.out.println("printing cookies -> "+i);
		}
	}
	
	
	@Test(priority=3)
	void get_multiple_cookies()
	{
	
		Response cookies_variable=when().get("https://github.com/");
		Map<String,String> mycookies=cookies_variable.getCookies();
		for(String key: mycookies.keySet())
		{
			System.out.println("Cookies name -> "+key+" : "+ cookies_variable.getCookie(key));
		}
		
		
	}
}
