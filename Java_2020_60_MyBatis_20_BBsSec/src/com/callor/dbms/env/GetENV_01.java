package com.callor.dbms.env;

import java.util.Map;

public class GetENV_01 {

	public static void main(String[] args) {

		Map<String,String> envList = System.getenv();
		
		System.out.println(envList.get("CALLOR"));
		System.out.println(envList.get("callor"));
		
		System.out.println(System.getenv("USERNAME"));
		
		
	}

}
