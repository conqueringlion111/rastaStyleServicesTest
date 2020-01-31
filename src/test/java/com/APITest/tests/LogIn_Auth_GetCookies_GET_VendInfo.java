package com.APITest.tests;

import com.framewerk.APITestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LogIn_Auth_GetCookies_GET_VendInfo extends APITestBase {
	
	static String SESSID;
	static String HSESSID2;
	static String COOKIE3;
	static String COOKIE4;
	
	@Test(dataProvider = "dataProvider", description = "login to authenticate, get cookies to use in second request")
	
	public void login_Auth_GetCookies_Run_GET(String myNewURI, String searchPath, String loginPath) {
		
		Map<String, String> myCookies = new HashMap<String, String>();
		
		Response response = 
				given()
				.header("Content-Type", "application/x-www.form-urlencoded")
				.contentType("multipart/form-data")
				.multiPart("data[User][password]", "myPassword123")
				.multiPart("data[User][user_name]", "originalRudeBwoy")
				.multiPart("_method", "POST")
				.post(myNewURI + loginPath)
				.then()
				.assertThat().statusCode(302)
				.log().all()
				.extract()
				.response();
		
		//get and set cookies - using set cookies doesn't work, will get cookie value from response.getCookie() directly****
		myCookies = response.getCookies();
		for (String cookie: myCookies.keySet()) {
			String key = cookie.toString();
			String value = myCookies.get(cookie).toString();
			System.out.println("Here are the cookie - key val pair " + key + " " + value);
		}
		
		SESSID = response.getCookie("PHPSESSID");
		HSESSID2 = response.getCookie("HASH_PHPSESSID");
		COOKIE3 = response.getCookie("CakeCookie[shq_random]");
		COOKIE4 = response.getCookie("HASH_CakeCookie[shq_random]");
		
		// Second request using the cookies from above request
		
		Response response2 = 
				given()
				.cookie("PHPSESSID", response.getCookie("PHPSESSID"))
				.cookie("HASH_PHPSESSID", response.getCookie("HASH_PHPSESSID"))
				.cookie("CakeCookie[shq_random]", response.getCookie("CakeCookie[shq_random]"))
				.cookie("HASH_CakeCookie[shq_random]", response.getCookie("HASH_CakeCookie[shq_random]"))
				.param("lookUp", "G & S Surf")
				.param("_", "110002311564")
				.when()
				.get(myNewURI + searchPath)
				.then().assertThat().statusCode(200)
				.and()
				.body(containsString("werd!!!"))
				.body(containsString("jeeaahhh"))
				.body(containsString("label"), containsString("wassup"), containsString("yo"))
				.log().all()
				.extract()
				.response()
				;
							
				
	}

}
