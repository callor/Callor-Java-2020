package com.callor.scanner;

import java.util.Scanner;

public class ScannerEx_05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("정수를 입력하세요");
		// scan
		String numPattern = "[0-9]*";
		try {
			String str = scan.next(numPattern);
			System.out.print( "입력한 숫자 :");
			System.out.println(str);

		} catch (Exception e) {
			System.out.println("정수만 입력해야 합니다");
		}

		System.out.println("전화번호를 000-0000-0000 패턴으로 입력하세요");
		String telPattern = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		try {
			while (scan.hasNext()) {
				String str = scan.next(telPattern);
				System.out.print("입력한 전화번호 : " );
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("문자열은 000-0000-0000 형식으로 입력해야 합니다");
		}

	}
}
