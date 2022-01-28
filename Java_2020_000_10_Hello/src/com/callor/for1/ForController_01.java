package com.callor.for1;

public class ForController_01 {
	
	
	public static void main(String[] args) {
		
		int intSum3 = 0;
		int intSum4 = 0;
		int intSum5 = 0;
		
		for(int index = 0 ; index < 100 ; index++) {
			int num = index + 1;
			if(num % 3 == 0) {
				intSum3 += num;
				if(num % 5 == 0) {
					intSum5 += num;
				}
			} else if (num % 4 == 0) {
				intSum4 += num;
			}
		}
		
		intSum3 = 0;
		intSum4 = 0;
		intSum5 = 0;
		
		for(int index = 0 ; index < 100 ;index++) {
			int num = index + 1;
			if(num % 3 == 0) {
				intSum3 += num;
			} else if(num % 4 == 0) {
				intSum4 += num;
			}
			
			if(num %3 == 0 && num % 5 == 0) {
				intSum5 += num;
			}
		}
		System.out.println("=======================");
		System.out.printf("3의 배수의 합 : %d\n",intSum3);
		System.out.printf("4의 배수의 합 : %d\n",intSum4);
		System.out.printf("3과 5의 배수의 합 : %d\n",intSum5);
		System.out.println("=======================");
		
		
	}

}
