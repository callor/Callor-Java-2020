package com.callor.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerEx_02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 정규식으로 패턴을 지정하여 유효성 검사를 한다
		// 정규식에 벗어난 형식을 입력하면 InputMismathException이 발생한다
		String pattern = "[0-9]*";
		try {
			System.out.println(scan.next(pattern));	
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다");
		}

		pattern = "[1-5]";
		try {
			System.out.println(scan.next(pattern));	
		} catch (InputMismatchException e) {
			System.out.println("1 ~ 5까지 정수만 입력할 수 있습니다");
		}
		
		
		// nextInt()는 next() method에 정수만 입력받는 정규식 패턴이 있는 것과 같다
		try {
			System.out.println(scan.nextInt());	
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다");
		}
		scan.close();
	}
}
