package com.APITest.data;

public class PostSamplePostReqData {
	
	/*
	 * Post body for samplePostReqest test
	 */
	
	public final String s200_SamPostReqTokenReturned = 
			"{" +
			"    \"email\": \"madLion@rasta.com\"," +
			"    \"password\": \"rudebwoy\"" +
			"}";
	
	
	/*
	 * Post body for s400_PostBodyMissingPW_ErrorReturned test
	 */
	
	public final String s400_MissingEmailField_ErrorReturned = 
			"{" +
			"	\"email\":	\"original@123\"" +
			"}";

}
