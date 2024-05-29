package api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoint;
import api.pojoPayload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker(); // THIS IS IMPORTNAT TO GENERATE AUTOMATIC DATA
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test
	public void PostMethod() {
		Response res = UserEndPoint.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}

}
