package com.callor.varriable.equals;

public class StringEQ_01 {
	
	
	public static void main(String[] args) {
		
		String str1 = "KOREA";
		String str2 = "KOREA";
		String str3 = new String("KOREA");
		
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str1.equals(str3));
		
		
	}

}
