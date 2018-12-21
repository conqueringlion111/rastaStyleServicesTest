package com.AutomationTestHelper.helper;

import java.io.IOException;
import java.util.Map;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class TestResultsTR {
	
	public static void addResultForTestCase(String TEST_RUN_ID, String TESTRAIL_USERNAME, String TESTRAIL_PASSWORD, 
    		String RAILS_ENGINE_URL, String testCaseId, int status,
            String error) throws IOException, APIException {

        String testRunId = TEST_RUN_ID;
        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map data = new java.util.HashMap();
        data.put("status_id", status);
        data.put("comment", "Selenium Test Executed - Status updated automatically from test result.");
        data.put("custom_browser", "1");
        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );
    }

}
