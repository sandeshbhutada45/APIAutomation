package Practices;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class DiffResponceBodyOrgJson {

	@Test (priority = 1)
	void responceBodyHashMap() {
		
		JSONObject data= new JSONObject();
		data.put("name", "Sandesh");
		data.put("id", "4");
		data.put("location", "Nagpur");
		data.put("phone", "123456789");
		String courArr[]= {"C","C++"};
		data.put("courses", courArr);
		
		given().contentType("application/json").body(data.toString())
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("Sandesh")).body("id", equalTo("4")).body("location", equalTo("Nagpur"))
		.body("phone", equalTo("123456789")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();		
		
	}
	
	@Test (priority = 2)
	void delete() {
		given()
		
		.when().delete("http://localhost:3000/students/4")
		
		.then().statusCode(200).log().all();
	}
}
