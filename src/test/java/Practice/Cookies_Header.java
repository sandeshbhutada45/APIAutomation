package Practice;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Cookies_Header {

	@Test
	public void getcookies() {
	
		 Response res = given()
		
		.when().get("https://www.google.com/");
		
		String cok= res.getCookie("AEC"); //// for Single cookkies
		 System.out.println("Cookies is: "+cok);
		 
		 
		 Map<String, String> all_cookies= res.getCookies();   ///All Cokkies 
		 System.out.println("All Cookies is: "+all_cookies.keySet());//only print keys
		 System.out.println("All Cookies is: "+all_cookies.values());//only print Values
		 System.out.println("All Cookies is: "+all_cookies);//Print Both
	}
	
	@Test
	public void testheader() {
	
		given()
		
		.when().get("https://www.google.com/")
		
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Server", "gws");	
		
	}
	
	@Test
	public void getheader() {
	
		Response res =given()
		
		.when().get("https://www.google.com/");
		
		String contenttype=res.getHeader("Content-Type");
		System.out.println("Single Header: "+contenttype);  //print single header 
		
		Headers head= res.getHeaders();
		System.out.println("All Headers: "+head);
		
		
	}
}
