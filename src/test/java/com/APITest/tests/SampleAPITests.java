package com.APITest.tests;

import org.testng.annotations.Test;

import com.framewerk.APITestBase;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SampleAPITests extends APITestBase {
	
	public final String postCommentsPath = "/posts/1/comments";
	public final String weatherInfoPath = "/data/2.5/weather";
	public final String weatherParm1 = "zip";
	public final String weatherParmVal1 = "30044";
	public final String userIDPath = "/posts";
	
	
	/*
	 *  get request - expecting 200 status and less than 10 sec response time
	 */
	
	@Test(description = "simple get call to validate the required fields are included in the response body")
	public void s200_Get_WeatherInfoByZipcode() {
		
		Response response = 
				given()
				.param("APPID", xAPIKey)
				.param(weatherParm1, weatherParmVal1)
				.when()
				.get(baseURLProd + weatherInfoPath)
				.then()
				.assertThat().statusCode(200)
				.and()
				.body(containsString("coord"))
				.body(containsString("weather"))
				.body("sys.country", containsString("US"))
				.body("coord.lon",  is(-122.09f), "coord.lat", is(37.39f))
				.body("main", hasKey("temp"), "main", hasKey("pressure"), "main", hasKey("humidity"))
				.body("main", hasKey("temp_min"), "main",hasKey("temp_max"))
				.body("main", not(hasKey("turbo")))
				.body("clouds.all", is(1), "name", is("Mountain View"))
				.log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		
		//get the cookie
		Map<String, String> allCookies = response.getCookies();
		for (String cookie: allCookies.keySet()) {
			String key = cookie.toString();
			String value = allCookies.get(cookie).toString();
			System.out.println("Here are the cookie(s) - key/val pair: " + key + " " + value);
		}
		int code = response.getStatusCode();
		String lon, lat;
		lon = response.body().path("coord.lon").toString();
		lat = response.body().path("coord.lat").toString();
		
		Assert.assertTrue(code==200, "The status code is not 200 --> Assertion Failed");
		
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) <= timeLimitInt, "Response Time is not within limit");
		System.out.println("The total response time is " + response.getTimeIn(TimeUnit.SECONDS) + " seconds");
		
		Assert.assertTrue(lon.contains("-122.09"), "The expected lon value was not returned --> Assertion Failed");
		
		Assert.assertTrue(lat.contains("37.39"), "The expected lat value was not returned --> Assertion Failed");
		
	}
	
	@Test(description = "simple get call to test this framework")
	public void s200_Get_PComments() {
		
		System.out.println("hitting endpoint " + baseURL + postCommentsPath);
		
		Response response = 
				given()
				.when()
				.get(baseURL + postCommentsPath)
				.then()
				.body(containsString("postId"))
				.body(containsString("id"))
				.body("[2].email", is("Nikita@garfield.biz"), "[2].body", is("quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"))
				.log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		
		//get the cookie
				Map<String, String> allCookies = response.getCookies();
				for (String cookie: allCookies.keySet()) {
					String key = cookie.toString();
					String value = allCookies.get(cookie).toString();
					System.out.println("Here are the cookie(s) - key val pair " + key + " " + value);
				}
		
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) <= timeLimitInt, "Response Time is not within limit");
		System.out.println("The total response time is " + response.getTimeIn(TimeUnit.SECONDS) + " seconds");
				
	}

}
