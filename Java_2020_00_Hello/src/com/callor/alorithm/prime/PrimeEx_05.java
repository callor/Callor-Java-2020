package com.callor.alorithm.prime;

import java.util.Random;

public class PrimeEx_05 {

	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		for(int i = 0 ; i < 10 ; i++) {
			int num = rnd.nextInt(1000);
			int result = prime(num);
			if( result < 0) {
				System.out.printf("%d 는 소수\n",num);
			} else {
				System.out.printf("%d 는 소수가 아님 \n",num);
			}
			
		}
	}
	
	
	private static int prime(int num) {
		for(int i = 2 ; i < num ; i ++) {
			if(num % 2 == 0) {
				return num;
			}
		}
		return -1;
	}


	@Override
	public String toString() {
		return "PrimeEx_05 []";
	}
	
	
	
	
}
