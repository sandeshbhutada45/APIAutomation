package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class Day1Test {

	@Test
	public void test1() {
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println(res.getHeader("content-type"));
	}

	@Test
	public void test2() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log()
				.all();
	}


	@Test
	public void test4_Post() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Sandesh");
		obj.put("Age", 18);
		System.out.println(obj);
		
		given().body(obj).
		when().post("https://reqres.in/api/users").
		then().statusCode(201).log().all();
	}
	
	@Test
	public void test5_Put() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Sandesh");
		obj.put("Job", "Emplyoee");
		System.out.println(obj);
		
		given().body(obj).
		when().put("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();
	}
	
	@Test
	public void test6_Patch() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Sandesh");
		obj.put("Job", "Emplyoee");
		System.out.println(obj);
		
		given().body(obj).
		when().patch("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();
	}
	
	@Test
	public void test7_Delete() {
		when().delete("https://reqres.in/api/users/2").then().statusCode(204);
	}
	
	@Test
	public void test8_LocalAPI() {
		
		JSONObject ob= new JSONObject();
		ob.put("name", "Sandesh");
		ob.put("Surname", "Bhutada");
		ob.put("Age", 25);
		ob.put("id", 2);
		
		given().body(ob.toString()).when().put("http://localhost:3000/students/ac69").then().statusCode(200);
	}
}
