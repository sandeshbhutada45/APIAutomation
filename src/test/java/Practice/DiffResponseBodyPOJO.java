package Practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DiffResponseBodyPOJO {

	@Test 
	void responseBodyHashMap() {
		Pojo_Post pp= new Pojo_Post();
		pp.setName("Test");
		pp.setId("4");
		pp.setPhone("1234567");
		pp.setPlace("TestCity");
		String courarr[]= {"Java", "C#"};	
		pp.setCourses(courarr);
		
		given().contentType("application/json").body(pp)
		
		.when().post("http://localhost:3000/students")
		
		.then().statusCode(201)
		.body("name", equalTo("Test")).body("id",equalTo("4"))
		.body("place", equalTo("TestCity"))
		.body("phone", equalTo("1234567")).body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C#"))
		.header("Content-Type", "application/json")
		.log().all();		
		
	}	

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test (priority = 2)
//	void delete() {
//		given()
//		
//		.when().delete("http://localhost:3000/students/4")
//		
//		.then().statusCode(200).log().all();
//	}
//}
