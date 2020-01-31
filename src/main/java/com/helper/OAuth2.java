package com.helper;

import com.appconstants.ApplicationConstants;
import com.framewerk.APITestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.lessThan;

public class OAuth2 extends APITestBase {

    private static String accessToken;
    private static String refreshToken;

    public OAuth2(String authEmail, String authPW, String grantType, String clientId, String clientSecret) {

        setAuthToken(authEmail, authPW, grantType, clientId, clientSecret);

    }

    private static void setAuthToken(String authEmail, String authPW, String grantType, String clientId, String clientSecret) {

        Response auth =
                given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.URLENC)))
                .formParam("username", authEmail)
                .formParam("password", authPW)
                .formParam("grant_type", grantType)
                .formParam("client_id", clientId)
                .formParam("resource", clientId) //resource is only needed for ms Azure oauth
                .then().expect().statusCode(200)
                .and().time(lessThan(10000L))
                .when().post(authenticationBaseURI + ApplicationConstants.TENANT_ID + ApplicationConstants.OAUTH_TOKEN_PATH)
                .then().contentType(ContentType.JSON).extract().response();
    }
}
