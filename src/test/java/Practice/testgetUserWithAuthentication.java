package Practice;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.pojoPayload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testgetUserWithAuthentication {

	@Test
	public void testGetUserWithAuthentication() {
	    String token = "YOUR_ACCESS_TOKEN";

	    Response response = RestAssured.given()
	        .auth()
	        .oauth2(token)
	        .get("https://gorest.co.in/public/v2/users/123");

	    Assert.assertEquals(response.getStatusCode(), 200);

	    User user = response.as(User.class);
	    Assert.assertNotNull(user);
	    Assert.assertEquals(user.getId(), 123);
	}
	
	@Test
	public void testUserResponseValues() {
	    Response response = RestAssured.get("https://gorest.co.in/public/v2/users/123");

	    response.then()
	        .assertThat()
	        .statusCode(200)
	        .body("id", equalTo(123))
	        .body("name", equalTo("John Doe"))
	        .body("email", equalTo("john.doe@example.com"));
	}


}
