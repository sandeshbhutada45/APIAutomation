package Practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffResponseBodyExternalFile {

	@Test 
	void responseBodyHashMap() throws FileNotFoundException {
		
		File file= new File(".//body.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject pp = new JSONObject(jt);
		
		given().contentType("application/json").body(pp.toString())
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("Tester")).body("id",equalTo("4"))
		.body("place", equalTo("NewYork"))
		.body("phone", equalTo("99999")).body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C#"))
		.header("Content-Type", "application/json")
		.log().all();		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test (priority = 2)
	void delete() {
		given()
		
		.when().delete("http://localhost:3000/students/2")
		
		.then().statusCode(200).log().all();
	}
}
