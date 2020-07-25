package com.callor.exam.exec;

import java.util.Random;

public class PrimeEx_01 {
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		int[] num = new int[100];
		
		for(int i = 0; i < num.length ; i++) {
			num[i] = rnd.nextInt(91) + 10;
		}
		
		for(int n : num) {
			int i = 0;
			for(i = 2 ; i < n ; i++) {
				if(n % i == 0) {
					break;
				}
			}
			// System.out.println(i + ":" + n);
			if(i >= n) {
				System.out.println(n+"은 소수입니다");
			}
		}
	}

}
