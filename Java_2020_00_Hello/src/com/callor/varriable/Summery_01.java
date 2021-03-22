package com.callor.varriable;

public class Summery_01 {

	public static void main(String[] args) {

		
		int intSum = 0;
		int intNum = 7;
		
		intSum += (intNum += 2);
		System.out.println(intSum);
		
		intSum += (intNum += 5);
		
		intSum += (intNum += 2);
		System.out.printf("Sum : %d, Num : %d\n",intSum, intNum);
		

	}

}
