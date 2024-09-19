package Practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameters {

//	https://reqres.in/api/users?page=2

	@Test
	void parameter() {
		given().pathParam("MyPath", "users") //Path Parameter
		.queryParam("page", 2)  //Query Parameter
		.when().get("https://reqres.in/api/{MyPath}")
		
		.then().statusCode(200).log().all();
	}
}
