package com.callor.scanner;

import java.util.Scanner;

public class ScannerEx_03 {

	/*
	 * 문자열, 파일을 구분 문자열을 기준으로 잘라내기
	 */
	public static void main(String[] args) {

		// 구분 문자열(\n)이 있는 문자열을 입력으로 하여 scanner 생성
		Scanner scan = new Scanner("123\n333\n2123\n").useDelimiter("\\n");

		/*
		 * 구분 문자열(\n)로 문자열을 잘라서
		 * 이때 구분 문자열(\n) 이후에 값이 있으면 hasNext()는 true
		 * 
		 * 파일이나, 문자열을 특정한 구분 문자열로 자르고자 할때 사용하는 코드 패턴
		 * 키보드 입력에서는 문제가 있다
		 */
		while(scan.hasNext()) {
			String str = scan.next();
			System.out.println(str);
		}
		scan.close();
	}

}
