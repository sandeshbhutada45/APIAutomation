package Practices;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class DiffResponceBodyExternalFile {

	@Test (priority = 1)
	void responceBodyHashMap() throws FileNotFoundException {
		
		File file= new File(".//body.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject pp = new JSONObject(jt);
		
		given().contentType("application/json").body(pp.toString())
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("Sandesh")).body("id",equalTo("4"))
		.body("place", equalTo("Amravati"))
		.body("phone", equalTo("25478548")).body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C#"))
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
