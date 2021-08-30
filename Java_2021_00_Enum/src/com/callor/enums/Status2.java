package com.callor.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status2 {
	
	대기,
	완료,
	실패;
		
	private static Map<String,Status2>statusMap = new HashMap<String,Status2>();
	static {
		for(Status2 status : values()) {
			statusMap.put(status.name(), status);	
		}
	}
	public static Status2 findByEnum(String eStr) {
		return statusMap.get(eStr);
	}
}
