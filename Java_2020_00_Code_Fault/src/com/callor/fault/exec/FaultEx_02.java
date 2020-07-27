package com.callor.fault.exec;

import java.util.Scanner;

public class FaultEx_02 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >>");

		String strNum = scan.nextLine();

		int intNum = 0;
		try {
			
			intNum = Integer.valueOf(strNum);
			
		} catch (NumberFormatException e) {
			System.out.println("반드시 숫자만 입력해야 합니다 !!!");
		}
		
		System.out.printf("%d * 3 = %d", intNum, intNum * 3);
		scan.close();
		
	}
	
	
}
