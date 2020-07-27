package com.callor.fault.exec;

import java.util.Arrays;
import java.util.Random;

public class FaultEx_03 {

	public static void main(String[] args) {
	
		Random rnd = new Random();
		int count = rnd.nextInt(31) + 10;
				
		int[] nums = new int[count];
	
		for(int i = 0 ; i < nums.length ; i++) {
			nums[i] = rnd.nextInt(100) + 1;
		}
		
		int sum = 0;
		float avg = 0;
		for(int i : nums) {
			sum += i;
			System.out.print(i + "\t");
		}

		System.out.println();
		avg = sum / nums.length;
		System.out.printf("평균 %.2f",avg);
		
	}
	
	
}
