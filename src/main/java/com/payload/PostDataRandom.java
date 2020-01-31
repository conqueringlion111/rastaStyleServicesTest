package com.payload;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;

public class PostDataRandom {
	
private final Map<Integer, String> randomStrs;
	
	@Deprecated
	public PostDataRandom() {
		this.randomStrs = Collections.emptyMap();
	}
	
	private PostDataRandom(int[] lengths) {
		this.randomStrs = new HashMap<Integer, String>(lengths.length);
		for (int l : lengths) {
			this.randomStrs.put(l, RandomStringUtils.randomAlphabetic(l));
		}
	}
	
	public static PostDataRandom newInstance(int...lengths) {
		return new PostDataRandom(lengths);
	}
	 
	public Optional<String> randomStrOfSize(int size) {
		return Optional.ofNullable(this.randomStrs.get(size));
	}
	
	public static String s200CreateCompany(String companyName, String shardName, String accountManager) {
		return "{" +
				"    \"company_name\": \"" + companyName + "\"," +
				"    \"shard_name\": \"" + shardName + "\"," +
				"    \"industry\": \"crystal\"," +
				"    \"account_manager\": \"" + accountManager + "\"," +
				"    \"contract_start_date\": \"2019-03-19\"," +
				"    \"contract_end_date\": \"2021-03-30\"," +
				"    \"executive_sponsor\": \"Gus\"," +
				"    \"refresh_cadence\": \"Monthly\"," +
				"    \"user_limit\": 25," +
				"    \"benchmarkable\": true," +
				"    \"cloud_enabled\": true" +
		"}";
	}

}
