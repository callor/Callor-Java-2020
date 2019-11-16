package com.callor.libs.hello;

public class CallorUtils {

	public static String stringLine(String str,int length) {
		
		StringBuilder strLine = new StringBuilder();
		for(int i = 0 ; i < length ; i++) {
			strLine.append(str);
		}
		return strLine.toString();
	}
}
