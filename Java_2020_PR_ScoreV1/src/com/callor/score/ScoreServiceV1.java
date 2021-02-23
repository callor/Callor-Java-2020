package com.callor.score;

import java.util.Random;
import java.util.Scanner;

public class ScoreServiceV1 {
	
	protected Scanner scan = null;
	protected Random rnd = null;
	
	protected int intKor[];
	protected int intEng[];
	protected int intMath[];
	
	protected String strNames[]; 
	
	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		rnd = new Random();
		
		intKor = new int[3];
		intEng = new int[3];
		intMath = new int[3];
		strNames = new String[] { "홍길동", "이몽룡", "성춘향" };
	}
	
	private String dLine(int num) {
		num = num < 1 ? 20 : num;
		return String.format("%0" + num + "d",0).replace("0","=");
	}
	private String sLine(int num) {
		num = num < 1 ? 20 : num;
		return String.format("%0" + num + "d",0).replace("0","-");
	}

	public int menu() {
		
		int intMenu = -1;
		while(true) {
			System.out.println(this.dLine(50));
			System.out.println("업무를 선택하세요");
			System.out.println(this.sLine(50));
			System.out.println("1. 성적입력");
			System.out.println("2. 리스트 출력");
			System.out.println("-1. 종료");
			System.out.println(this.sLine(50));
			System.out.print("업무번호 >> ");
			String strMenu = scan.nextLine();
			
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("업무선택은 -1, 1 ~ 2 숫자로만 입력하세요");
				continue;
			}
			
			if(intMenu > 2) {
				System.out.println("업무선택은 -1, 1 ~ 2 숫자로만 입력하세요");
				continue;
			}
			break;
		}
		return intMenu;
	}
	
	public void rndScore() {
		
		for (int index = 0; index < strNames.length; index++) {
			intKor[index] = rnd.nextInt(100) + 1;
			intEng[index] = rnd.nextInt(100) + 1;
			intMath[index] = rnd.nextInt(100) + 1;
		}
	}

	
	public void print() {
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
