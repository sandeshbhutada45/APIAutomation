package Practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
public class SchemaValidation {

	
	@Test
	void JsonSchemaValidation() {
		given()
		
		.when().get("http://localhost:3000/students")
		
		//JsonSchemaValidator.matchesJsonSchemaInClasspath fetch .json file from same project directory.
		
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}
}
