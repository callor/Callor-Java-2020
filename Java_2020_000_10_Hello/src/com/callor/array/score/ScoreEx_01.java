package com.callor.array.score;

import java.util.Random;

public class ScoreEx_01 {

	public static void main(String[] args) {

		Random rnd = new Random();

		String strName[] = new String[] {"홍길동","이몽룡","성춘향"};
		
		int intKor[] = new int[3];
		int intEng[] = new int[3];
		int intMath[] = new int[3];

		for (int index = 0; index < strName.length; index++) {
			
		
			intKor[index] = rnd.nextInt(100) + 1;
			intEng[index] = rnd.nextInt(100) + 1;
			intMath[index] = rnd.nextInt(100) + 1;

		}
		
		System.out.println("==============================================");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("----------------------------------------------");
		for(int index = 0 ; index < strName.length ;index++) {
			System.out.printf("%s\t%d\t%d\t%d\n",strName[index], intKor[index],intEng[index],intMath[index]);
		}
		System.out.println("----------------------------------------------");
		
		
		

	}

}
