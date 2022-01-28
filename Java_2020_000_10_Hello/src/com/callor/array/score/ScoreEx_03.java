package com.callor.array.score;

import java.util.Scanner;

public class ScoreEx_03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int intKor[] = new int[3];
		int intEng[] = new int[3];
		int intMath[] = new int[3];

		for (int index = 0; index < 3; index++) {
			System.out.println("각 과목 성적을 입력하세요");
		
			System.out.print("국어 >> ");
			intKor[index] = scan.nextInt();
			
			System.out.print("영어 >> ");
			intEng[index] = scan.nextInt();

			System.out.print("수학>> ");
			intMath[index] = scan.nextInt();
		}
		
		System.out.println("==============================================");
		System.out.println("국어\t영어\t수학");
		System.out.println("----------------------------------------------");
		for(int index = 0 ; index < 3 ; index ++) {
			System.out.printf("%d\t%d\t\n",intKor[index],intEng[index],intMath[index]);
		}
		
		scan.close();

	}

}
