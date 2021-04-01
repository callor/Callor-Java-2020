package com.callor.array.score;

import java.util.Random;

public class ScoreEx_04 {

	public static void main(String[] args) {

		Random rnd = new Random();

		String strNames[] = new String[] { "홍길동", "이몽룡", "성춘향" };
		int intKor[] = new int[3];
		int intEng[] = new int[3];
		int intMath[] = new int[3];

		for (int index = 0; index < strNames.length; index++) {

			intKor[index] = rnd.nextInt(100) + 1;
			intEng[index] = rnd.nextInt(100) + 1;
			intMath[index] = rnd.nextInt(100) + 1;

		}

		int intSum = 0;
		float floatAvg = 0.0f;
		System.out.println("==============================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
		for (int index = 0; index < strNames.length; index++) {
			

			intSum = intKor[index];
			intSum += intEng[index];
			intSum += intMath[index];

			floatAvg = (float) intSum / 3;
			
			
			System.out.printf("%s\t%3d\t%3d\t%3d\t%5d\t%3.2f\n", strNames[index], intKor[index], intEng[index], intMath[index],intSum, floatAvg);
		}
		System.out.println("==============================================");


	}

}
