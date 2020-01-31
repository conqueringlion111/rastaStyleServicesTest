package com.APITest.tests;

import org.testng.annotations.Test;

import com.framewerk.APITestBase;

import static io.restassured.RestAssured.given;

import com.payload.PostSamplePostReqData;

import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SamplePostRequest extends APITestBase {
	
	public String registerPath = "/api/register";
	public String userIDPath = "/posts";
	
	/*
	 *  sample post request - expecting 200 and response time less than 10 sec
	 */
	
	@Test(dataProvider = "dataProvider", description = "simple post call to test this framework")
	public void s200_RegisterTokenReturned(String containsStr1) {
		
		System.out.println("hitting endpoint " + baseURIReqres+registerPath);
		PostSamplePostReqData data = new PostSamplePostReqData();
		String myPostJson = data.s200_SamPostReqTokenReturned;
		
		Response response = 
				given()
				.body(myPostJson).with().contentType("application/json")
				.then().expect().statusCode(201)
				.body(containsString(containsStr1))
				.and().time(lessThan(7000L))
				.when().post(baseURIReqres + registerPath)
				.then().log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
	}
	
	@Test(dataProvider = "dataProvider", description = "testing error handling")
	public void s400_MissingEmailField_ErrorReturned(String errVal1) {
		
		PostSamplePostReqData data = new PostSamplePostReqData();
		String myPostJson = data.s400_MissingEmailField_ErrorReturned;
		
		Response response = 
				given()
				.body(myPostJson).with().contentType("application/json")
				.then().expect().statusCode(400)
				.body(containsString("error"))
				.body("error", is(errVal1))
				.and().time(lessThan(7000L))
				.when().post(baseURIReqres + registerPath)
				.then().log().all().contentType(ContentType.JSON)
				.extract()
				.response();
		
	}

}
