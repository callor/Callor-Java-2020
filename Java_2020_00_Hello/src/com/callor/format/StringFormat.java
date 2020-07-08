package com.callor.format;

public class StringFormat {

	public static void main(String[] args) {
		
		System.out.println(String.format("%d", 30)); // 10진수 정수
		System.out.println(String.format("%f", 30.2f)); // 10진수 실수
		
		System.out.println(String.format("%X",30)); // 16진수 변환
		System.out.println(String.format("%o",30)); // 8진수 변환
		
		System.out.println(String.format("%s","대한민국")); // 문자열
		

		
		
		
	}
	
	
}
