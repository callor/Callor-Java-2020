package com.callor.scanner;

import java.util.Scanner;

public class ScannerEx_01 {

	public static void main(String[] args) {

		// 문자열을 소스로 입력받으며 scan 객체 생성
		Scanner scan = new Scanner("BBB 12 313 55 123 AAA");
		
		// 입력 패턴을 제한한다
		String pattern = "[0-9]*";
 
		try {
			while (scan.hasNext()) {
				String input = scan.next(pattern);
				System.out.println(input);
			}
		} catch (Exception e) {
			System.out.println("문자열에 숫자 이외의 값이 있음");
		}
		// closing the scanner stream
		scan.close();

	}

}
