package com.callor.array.applications;

import java.util.Random;

public class ArrayInteger {
	
	public static void main(String[] args) {
		
		Random rnd = new Random(1);
		Integer intArray[] = new Integer[100];
		
		for(int i = 0 ; i < intArray.length ; i++) {
			intArray[i] = rnd.nextInt(100) + 1;
		}
		for(Integer n : intArray) {
			System.out.println(n);
		}
		
		
	}
	

}
