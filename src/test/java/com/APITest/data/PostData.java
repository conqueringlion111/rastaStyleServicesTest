package com.APITest.data;

public class PostData {
	
	public final String myJson = "{\"uIds\":[\"131210243164\"],\"tableNames\":"
			+ "[\"dmp20160831.x_13121\"],\"sfdcData\":[],\"topicData\":[{\"topic_id\":\"statename\","
			+ "\"field\":\"FirstName\"},{\"topic_id\":\"countyname\",\"field\":\"LastName\"},"
			+ "{\"topic_id\":\"site_city\",\"field\":\"City\"},{\"topic_id\":\"site_state\",\"field\":\"State\"},"
			+ "{\"topic_id\":\"site_zip\",\"field\":\"PostalCode\"}],\"dataType\":\"dmp-v1\"}";
	

	public final String deleteJsonBody = "{"
 + "\"vendorname\": \"RBShoesRSTestVendor\""
 + "}";
	
	
	public final String clientNameJson = "{"
			+ "\"clientname\": \"NewClientName111\""
			+ "}";
	
	public final String externalIdJson = "{"
			+ "\"externalid\": \"e3c91902-6d22-45fd-bd35-d4242fcab905\","
			+ "\"sfdcid\": \"a0m41000009L9EDAA0\""
			+ "}";
	
	public final String externallIdJson = "{\"externalid\": \"00000-6d22-45fd-0000-d4242fca0000\",\"sfdcid\": \"a0m41000009L9E000\"}";
	
	
	public final String RBAuthSettingsEmail = "{"
			+	"\"email\":\"yoyo_test12345@mymail.com\""		
			+   "}";
	
	public final String RBAuthSettingsLiveApp = "{"
			+ "\"settings\":["
		    + 	"{"
		    +			"\"eventType\":\"red_button_press\","
		    +			"\"title\":\"Red One\","
		    +			"\"description\":\"description 1\","
		    +			"\"isVisible\":true,"
		    +			"\"icon\":\"octagon\""
		    			
		    +		"},"
		    +		"{"
		    +			"\"eventType\":\"blue_button_press\","
		    +			"\"title\":\"Blue Two\","
		    +			"\"description\":\"description 2\","
		    +			"\"isVisible\":true,"
		    +			"\"icon\":\"square\""
		    			
		    +		"},"
		    +		"{"
		    +			"\"eventType\":\"yellow_button_press\","
		    +			"\"title\":\"Yellow Three\","
		    +			"\"description\":\"description 3\","
		    +			"\"isVisible\":true,"
		    +			"\"icon\":\"triangle\""
		    			
		    +		"},"
		    +		"{"
		    +			"\"eventType\":\"green_button_press\","
		    +			"\"title\":\"Green Four\","
		    +			"\"description\":\"description 4\","
		    +			"\"isVisible\":true,"
		    +			"\"icon\":\"oval\""
		    				
		    +		"}"
		    +	"]"
		
			+"}";
	
	

}
