package com.callor.alorithm;

import java.util.Random;

public class EvenEx_01 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int evenSum = 0;
		int oddSum = 0;
		System.out.println(String.format("%050d",0).replace("0","="));
		System.out.println("1 ~ 100 범위의 랜덤수 홀수 판별");
		System.out.println(String.format("%050d",0).replace("0","="));
		for (int i = 0; i < 10; i++) {
			int num = rnd.nextInt(100) + 1;
			if (num % 2 == 0) {
				System.out.printf("%5d : 짝수(Even)\n", num);
				evenSum += num;
			} else {
				System.out.printf("%5d : 홀수(Odd)\n", num);
				oddSum += num;
			}
		}
		System.out.println(String.format("%050d",0).replace("0","-"));
		System.out.printf("짝수의 합 : %7d\n",evenSum);
		System.out.printf("홀수의 합 : %7d\n",oddSum);
		System.out.println(String.format("%050d",0).replace("0","="));
	}
}
