package com.callor.random;

import java.util.Random;

/*
 * 임의의 문자 생성
 */
public class MathRandomChar {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 100; i++) {
		    double dValue = Math.random();
		    char cValue = (char)((dValue * 26) + 65);   // 대문자
		    System.out.print(cValue + ", ");

		}
		System.out.println();
		for(int i = 0; i < 100; i++) {
		    double dValue = Math.random();
		    char cValue = (char)((dValue * 26) + 97); // 소문자
		    System.out.print(cValue + ", ");
		}



		
		
		
		
	
	}
	
}
