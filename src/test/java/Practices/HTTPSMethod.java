package Practices;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

//given(): content type add authentication, add parameters and set headers...... 
//when (): GET PUT POST DELETE methods
//then(): all validation parts we have to cover in then, validate status code, extract response, cookies and response bodies.

public class HTTPSMethod {
	int ID;

	@Test(priority = 1)
	public void Get() {
//		given().
		when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log().all();

	}

	@Test(priority = 2)
	public void Createuser() {
		HashMap data = new HashMap();
		data.put("name", "Sandesh");
		data.put("job", "Employee");

		ID = given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");
		System.out.println(ID);

//		.then().statusCode(201).log().all();

	}

	@Test(priority = 3)
	public void Updateuser() {
		HashMap data = new HashMap();
		data.put("name", "Bhutada");
		data.put("job", "Majdoor");

		given().contentType("application/json").body(data).when().put("https://reqres.in/api/users/" + ID)

				.then().statusCode(200).log().all();

	}

	@Test(priority = 4)
	public void DeleteData() {

		given().when().delete("https://reqres.in/api/users/" + ID)

				.then().statusCode(204).log().all();

	}
}
