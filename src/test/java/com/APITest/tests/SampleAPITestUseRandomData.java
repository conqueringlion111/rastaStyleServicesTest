package com.APITest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payload.PostDataRandom;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SampleAPITestUseRandomData {
	
	@Test()
	public void sampleLinkedRestCallsUsingRandomPostTestData() {
	
		final PostDataRandom data = PostDataRandom.newInstance(7, 8);
		final String companyName = "my company name " + data.randomStrOfSize(7).orElseThrow(RuntimeException::new);
		final String shardName = "my shardName " + data.randomStrOfSize(8).orElseThrow(RuntimeException::new);	
		final String accountManager = "my account manager " + data.randomStrOfSize(8).orElseThrow(RuntimeException::new);	
		String myJson = PostDataRandom.s200CreateCompany(companyName, shardName, accountManager);
		
		final String companyPath = "/companies";
		final String paramPg = "2";
		final String pgVal1 = "1";
		final String paramPerPg = "per page";
		final String pgValMax = "1500";
		
		String uuidVal = "";
		
		int dataObjCt;
		Response response = 
				given()
				.relaxedHTTPSValidation()
				.header("Content-Type","application/json")
				.header("Accept", "application/json")
				.body(myJson).with()
				.then().expect().statusCode(200)
				.body(containsString("data"))
				.body("data", hasKey("uuid"), "data", hasKey("company_name"), "data", hasKey("shard_name"))
				.body("data", hasKey("industry"), "data", hasKey("account_manager"), "data", hasKey("contract_start_date"))
				.body("data", hasKey("executive_sponsor"), "data", hasKey("refresh_cadence"), "data", hasKey("user_limit"))
				.body("data", hasKey("benchmarkable"), "data", hasKey("cloud_enabled"), "data", hasKey("archivable"))
				.body("data", hasKey("is_active"), "data", hasKey("modules"))
				.body("data.company_name", is(companyName))
				.body("data.shard_name", is(shardName))
				.and().time(lessThan(7000L))
				.when().post(baseURI + companyPath)
				.then().log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		
			uuidVal = response.jsonPath().get("data.uuid").toString();
			System.out.println("extracted uuid value = " + uuidVal);
			
			/*
			 * Delete the created company using the provided uuid value
			 */
			Response responseDel = 
					given()
					.relaxedHTTPSValidation()
					.header("Content-Type","application/json")
					.header("Accept", "application/json")
					.expect().statusCode(204)
					.and().time(lessThan(7000L))
					.when().delete(baseURI + companyPath+"/" + response.jsonPath().get("data.uuid").toString())
					.then().log().all()
					.extract()
					.response();
			/*
			 * Execute GET and assert deleted uuid does not exist in the returned company data object
			 */
			Response responseCompList = 
					given()
					.relaxedHTTPSValidation()
					.queryParam(paramPg, pgVal1)
					.queryParam(paramPerPg, pgValMax)
					.when()
					.get(baseURI + companyPath)
					.then()
					.assertThat().statusCode(200)
					.and().time(lessThan(7000L))
					.log().all()
					.contentType(ContentType.JSON)
					.extract()
					.response();
	
			dataObjCt = responseCompList.body().path("data.size()");
			for(int i = 0; i < dataObjCt; ++i) {
				System.out.println("asserting against data Obj index " + i );
				Assert.assertFalse(responseCompList.body().path("data["+ i +"].uuid").toString().contains(uuidVal));
			}
		
	}

}
