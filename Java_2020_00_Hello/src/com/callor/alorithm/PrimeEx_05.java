package com.callor.alorithm;

import java.util.Random;

public class PrimeEx_05 {

	public static void main(String ...args) {
		
		Random rnd = new Random();
		int nums[] = new int[10];
		for(int i = 0 ; i < nums.length ; i++) {
			nums[i] = rnd.nextInt(1000) + 2;
		}
		int count = 0 ;
		for(int n : nums) {
			System.out.printf("%d\t",n);
			if(++count%5 == 0) System.out.println();
		}
		
		for(int i = 0 ; i < nums.length ; i++) {
			
			int j = 0;
			for(j = 2 ; j< nums[i] ; j++) {
				if(nums[i] % j == 0) break;
//				System.out.println(j);
			}
			
			if(j >= nums[i]) {
				System.out.printf("%5d : Prime\n",nums[i]);
			} else {
				System.out.printf("%5d : No~~ Prime\n",nums[i]); 
			}
			
		}
		
		
		
		
		
		
		
	}
	
}
