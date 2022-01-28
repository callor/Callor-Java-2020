package com.callor.varriable.equals;

public class IntegerEQ_01 {

	public static void main(String[] args) {
		
		int num1 = 30;
		int num2 = 30;
		
		@SuppressWarnings("deprecation")
		Integer num3 = new Integer(30);
		
		System.out.println(num1 == num2);
		System.out.println(num3.equals(num2));
		
	}
	
}
