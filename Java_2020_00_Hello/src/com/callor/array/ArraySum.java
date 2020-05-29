package com.callor.array;

import java.util.Random;

public class ArraySum {

	public static void main(String[] args) {
		
		int[] intNum = new int[100];
		Random rnd = new Random();	
		
		for(int i = 0 ; i <  100 ; i++) {
			intNum[i] = rnd.nextInt(100) + 1;
		}
		
		int intSum  = 0 ;
		for(int i = 0 ; i < 100 ; i++) {
			
			System.out.printf("%d\t",intNum[i]);
			intSum += intNum[i];
			if( (i+1) % 5 == 0) {
				System.out.printf("%d\n",intSum);
				intSum = 0;
			}
			
		}
	}
	
	
}
