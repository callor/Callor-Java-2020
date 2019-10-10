package com.callor.bank.exec;

import java.util.Scanner;

public class BankEx_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// balance : 잔고(예금잔고)
		int intBalance = 100000;
		
		while(true) {
			System.out.println("============================");
			System.out.println("광한루 은행");
			System.out.println("============================");
			System.out.println("1.조회 2.입금 3.출금 0.종료");
			System.out.println("----------------------------");
			System.out.print("선택>>");
			String strMenu = scanner.nextLine();
			int intMenu = Integer.valueOf(strMenu);
			
			switch(intMenu) {
			case  0 :
				System.out.println("업무종료");
				break;
			case  1 :
				System.out.println("계좌조회");
			case  2 :
				System.out.println("입금처리");
			case  3 :
				System.out.println("출금처리");
			}
			if(intMenu == 0) break;
			
		}
		
	}

}
