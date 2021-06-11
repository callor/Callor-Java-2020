package com.callor.reference;

public class Wrapper_01 {

	
	public static void main(String[] args) {
		
		String str = "대한민국";
		System.out.println(str);
		
		// wrapper class는 항상 Call by value로 작동
		updateStr(str);
		System.out.println(str);
		
		Integer num = 0;
		num = 100;
		
		// wrapper class는 항상 Call by value로 작동
		updateInt(num);
		System.out.println(num);
		
	}
	
	
	public static void updateStr(String str) {
		str = "우리나라";
	}
	
	public static void updateInt(Integer num) {
		num = 200;
	}
}
