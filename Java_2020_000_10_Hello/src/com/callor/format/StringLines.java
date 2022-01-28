package com.callor.format;

public class StringLines {

	public static void main(String[] args) {
	
		// Java 11에 추가된 method
		// 연속된 문자열 만들기
		System.out.println("-".repeat(150));
		
	}
	
	public static String dLine(int nCount) {
		return String.format("%0" + nCount + "%d", 0).replace("0", "=");
	}
	
	public static String sLine(int nCount) {
		return "-".repeat(nCount);
	}
	
	
}
