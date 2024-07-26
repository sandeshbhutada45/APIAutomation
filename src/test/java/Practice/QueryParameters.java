package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

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
