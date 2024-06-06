package Practices;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class schemaValidation {

	
	@Test
	void jsonschemavalidation() {
		given()
		
		.when().get("http://localhost:3000/students")
		
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}
}
