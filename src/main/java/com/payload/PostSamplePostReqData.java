package com.payload;

public class PostSamplePostReqData {
	
	/*
	 * Post body for samplePostReqest test
	 */
	
	public static final String s200_SamPostReqTokenReturned =
			"{" +
			"    \"email\": \"eve.holt@reqres.in\"," +
			"    \"password\": \"pistol\"" +
			"}";
	
	
	/*
	 * Post body for s400_PostBodyMissingPW_ErrorReturned test
	 */
	
	public static final String s400_MissingEmailField_ErrorReturned =
			"{" +
			"	\"email\":	\"original@123\"" +
			"}";

}
