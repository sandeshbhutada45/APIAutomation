package Practices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DiffResponceBodyPOJO {

	@Test (priority = 1)
	void responceBodyHashMap() {
		
		Pojo_Post pp= new Pojo_Post();
		pp.setName("Sandesh");
		pp.setId("4");
		pp.setPhone("25478548");
		pp.setPlace("Amravati");
		String courarr[]= {"Java", "C#"};	
		pp.setCourses(courarr);
		
		given().contentType("application/json").body(pp)
		
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
