package com.AutomationTestHelper.helper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OAuth2Helper {
	
	final String baseURI = "https://rbshoes.com/api";
	final String oauth2Path = "/auth/token";
	
	private String accessToken;
	private String refreshToken;
	
	public void setAuthToken(String authEmail, String authPassword) {
		
		Response auth = 
				given()
				.relaxedHTTPSValidation()
				.parameter("username",authEmail)
				.parameter("password",authPassword)
				.parameter("grant_type","password")
				.parameter("client_id","client77")
				.parameter("client_secret","wTNcCZFn8KWC0BzN63z4Ravz64xTizBo7iKOBCaZ")
				.auth().preemptive().basic(authEmail, authPassword)
				.then().expect().statusCode(200)
				.and().time(lessThan(7000L))
				.when().post(baseURI + oauth2Path)
				.then().log().all()
				.contentType(ContentType.JSON)
				.extract().response();
		
		setAccessToken(auth.body().path("access_token").toString());
		setFrefreshToken(auth.body().path("refresh_token").toString());
				
	}
	
	public void setAccessToken(String accToken) {
		this.accessToken = accToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setFrefreshToken(String refreToken) {
		this.refreshToken = refreToken;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}

}
