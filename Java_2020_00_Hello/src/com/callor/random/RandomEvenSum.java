package com.callor.random;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomEvenSum {

	public static void main(String[] args) {

		Random rnd = new Random();
		
		
		int enterCount = 0;
		int intEven = 0;
		for(int i = 0 ; i < 100 ; i++) {
			
			int num = rnd.nextInt(100) + 1;
			if(num % 2 == 0) {
				intEven += num;
				System.out.print(num + "\t");
				enterCount++;
				if(enterCount % 5 == 0) {
					System.out.println();
				}
			}
		}
		DecimalFormat formatter = new DecimalFormat("#,###,###");
		System.out.println("\n==============================================");
		System.out.printf("짝수의 합 : %s\n", formatter.format(intEven));
		System.out.println("==============================================");
		
		
		
	}

}
