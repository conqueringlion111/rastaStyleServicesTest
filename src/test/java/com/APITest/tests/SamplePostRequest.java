package com.APITest.tests;

import com.framewerk.APITestBase;
import com.payload.PostSamplePostReqData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SamplePostRequest extends APITestBase {
	
	public String registerPath = "/api/register";
	public String userIDPath = "/posts";
	
	/*
	 *  sample post request - expecting 200 and response time less than 10 sec
	 */
	
	@Test(dataProvider = "dataProvider", description = "simple post call to test this framework")
	public void s200_RegisterTokenReturned(String containsStr1) {
		
		System.out.println("hitting endpoint " + baseURIReqres+registerPath);

				given()
						.header("Content-Type", "application/json")
						.body(PostSamplePostReqData.s200_SamPostReqTokenReturned)
						.when()
						.post(baseURIReqres + registerPath)
						.then().assertThat().statusCode(200)
						.body(containsString(containsStr1))
						.body("$", hasKey("id"))
						.body("$", hasKey("token"))
						.and().time(lessThan(7000L))
						.log().all();
	}
	
	@Test(dataProvider = "dataProvider", description = "testing error handling")
	public void s400_MissingEmailField_ErrorReturned(String errVal1) {

			given()
					.header("Content-Type", "application/json")
					.body(PostSamplePostReqData.s400_MissingEmailField_ErrorReturned)
					.when().post(baseURIReqres + registerPath)
					.then().assertThat().statusCode(400)
					.body(containsString("error"))
					.body("error", is(errVal1))
					.and().time(lessThan(7000L))
					.log().all();
		
	}

}
