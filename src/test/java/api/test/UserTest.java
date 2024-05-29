package api.test;

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

	@Test(priority = 1)
	public void PostMethod() {
		Response res = UserEndPoint.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}

	@Test(priority = 2)
	public void GetMethod() {
		Response res = UserEndPoint.readUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}

	@Test(priority = 3)
	public void PutMethod() {
		Response res = UserEndPoint.updateUser(userPayload, this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}

	@Test(priority = 4)
	public void DeleteMethod() {
		UserEndPoint.deleteUser(this.userPayload.getUsername()).then().statusCode(200).log().all();
	}
}
