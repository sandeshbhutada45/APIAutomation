package Practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class DiffResponseBodyHashMap {

	@Test
	void responseBodyHashMap() {
		
		HashMap<String, Object> data= new HashMap<String, Object>();
		data.put("name", "Tester");
		data.put("id", "4");
		data.put("location", "China");
		data.put("phone", "123456789");
		String courArr[]= {"C","C++"};
		data.put("courses", courArr);
		
		given().contentType("application/json").body(data)
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("Tester")).body("id", equalTo("4")).body("location", equalTo("China"))
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
