package com.callor.dbms.env;

import java.util.Map;
import java.util.Set;

public class GetENV_01 {

	public static void main(String[] args) {

		Map<String,String> envList = System.getenv();
		
		System.out.println(envList.get("CALLOR"));
		System.out.println(envList.get("callor"));

		
		Set<String> keys = envList.keySet();
		for(String key : keys) {
			System.out.printf("%s : %s",key,envList.get(key));
		}
		
		System.out.println(System.getenv("USERNAME"));
		
		
	}

}
