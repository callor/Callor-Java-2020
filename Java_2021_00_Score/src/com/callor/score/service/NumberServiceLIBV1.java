package com.callor.score.service;

import java.util.Scanner;

public class NumberServiceLIBV1 {
	
	protected final Scanner scan;
	public NumberServiceLIBV1() {
		scan = new Scanner(System.in);
	}
	
	public Integer inputNum() {
		
		
		return null;
	}
	
	public Integer inputNum(String title) {
		
		while(true) {
			
			System.out.println("=".repeat(50));
			System.out.println(title + " 값을 입력하세요(QUIT:취소)");
			System.out.print(">> ");
			String strInput = scan.nextLine();
			Integer retNum = 0;
			
			if(strInput.equals("QUIT")) {
				return null;
			} else {
				try {
					retNum = Integer.valueOf(strInput);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("유효한 정수값이나, QUIT를 입력하세요");
					continue;
				}
			}
			return retNum;
		}
	}

}
