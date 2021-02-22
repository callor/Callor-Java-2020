package com.callor.ansi.exec;

import java.util.Scanner;

public class ScannerEx_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("nextLine()");
		String str = scan.nextLine();
		
		System.out.println(str);
		
		System.out.println("nextInt()");
		int num = scan.nextInt();
		System.out.println(num);
		
		// 문자열이 입력될때까지 기다리기
		// Enter를 눌러도 다음으로 진행되지 않는다
		System.out.print("next()");
		str =  scan.next();
		
		System.out.println(str);
		
	}

}
