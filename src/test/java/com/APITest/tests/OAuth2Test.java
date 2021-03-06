package com.APITest.tests;

import com.payload.PostData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class OAuth2Test {
	
	@Test()
	public void createCompanyNegativePath() {
		
		final String baseURI = "https://rbshoes.com/api";
		final String oauth2Path = "/auth/token";
		final String companyPath = "/companies";
	
		PostData data = new PostData();
		String myJson = data.clientNameJson;
		
		Response auth = 
				given()
				.relaxedHTTPSValidation()
				.formParam("username","inspectorGadget@mycartoon.com")
				.formParam("password","secret77")
				.formParam("grant_type","password")
				.formParam("client_id","client77")
				.formParam("client_secret","wTNcCZFn8KWC0BzN63z4Ravz64xTizBo7iKOBCaZ")
				.auth().preemptive().basic("amarvin@example.org", "test")
				.when().post(baseURI + oauth2Path)
				.then().assertThat().statusCode(200)
				.and().time(lessThan(7000L))
				.log().all()
				.extract().response();
		
		Response response = 
				given()
				.auth().oauth2(auth.body().path("access_token").toString())
				.relaxedHTTPSValidation()
				.header("Content-Type","application/json")
				.header("Accept", "application/json")
				.body(myJson)
				.when().post(baseURI + companyPath)
				.then().assertThat().statusCode(422)
				.body(containsString("message"))
				.body(containsString("errors"))
				.body("message", is("The given data was invalid."))
				.body("errors.company_name[0]", is("The company name field is required."))
				.body("errors.contract_start_date[0]", is("The contract start date is not a valid date."))
				.body("errors.contract_end_date[0]", is("The contract end date is not a valid date."))
				.body("errors.refresh_cadence[0]", is("The selected refresh cadence is invalid."))
				.body("errors.shard_name[0]", is("The shard name must be a string."))
				.body("errors.industry[0]", is("The industry must be a string."))
				.and().time(lessThan(7000L))
				.log().all()
				.extract()
				.response();
		
	}

}
