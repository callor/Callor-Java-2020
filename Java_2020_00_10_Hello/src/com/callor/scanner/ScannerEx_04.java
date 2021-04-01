package com.callor.scanner;

import java.util.Scanner;

public class ScannerEx_04 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*
		 * nextInt()과 nextLine() 를 같이 사용하면 문제가 발생한다
		 * nextInt()에서 입력된 Enter(\n)이 처리되지 못하고
		 * 		nextLine()로 전달되면서
		 * nextLine() method에서 blocking(대기)가 사라져 버린다
		 * 
		 * 이때 nextLine() 대신 next()를 사용하여 문제를 해결한다
		 */
		while(true) {
			System.out.print("정수 >> ");
			System.out.println("입력한 정수 : " + scan.nextInt());
			
			System.out.print("문자열(QUIT:끝내기) >> ");
			String str1 = scan.next();
			if(str1.equals("QUIT")) break;
			System.out.println("입력한 문자열 : " + str1);
		}
		
		scan.close();
		
	}
}
