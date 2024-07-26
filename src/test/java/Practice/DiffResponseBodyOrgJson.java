package Practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DiffResponseBodyOrgJson {

	@Test 
	void responseBodyHashMap() {
		
		JSONObject data= new JSONObject();
		data.put("name", "QA");
		data.put("id", "4");
		data.put("location", "City");
		data.put("phone", "123456789");
		String courArr[]= {"C","C++"};
		data.put("courses", courArr);
		
		given().contentType("application/json").body(data.toString())
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("QA")).body("id", equalTo("4")).body("location", equalTo("City"))
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
