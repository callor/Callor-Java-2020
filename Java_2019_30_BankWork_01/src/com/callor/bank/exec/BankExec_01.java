package com.callor.bank.exec;

import java.util.Scanner;

public class BankExec_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// 계좌번호
		String strAccNum = "0001";
		// balance : 잔고(예금잔고)
		int intBalance = 100000;
		
		System.out.println("============================");
		System.out.println("광한루 은행");
		System.out.println("============================");
		System.out.println("1.조회 2.입금 3.출금 0.종료");
		System.out.println("----------------------------");
		System.out.print("선택>>");
		String strMenu = scanner.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		
		if(intMenu == 0) {
			System.out.println("업무종료");
		} else if(intMenu == 1) {
			System.out.println("계좌조회");
			/*
			 * 1. 계좌번호를 입력받기
			 * 2. 일치하는 계좌번호가 있으면
			 * 3. 계좌내역을 보여주기
			 */
			System.out.print("계좌번호>>");
			String strAccKeyIn = scanner.nextLine();
			if(strAccKeyIn.equals(strAccNum)) {
				System.out.println("==================");
				System.out.printf("계좌번호: %s\n",strAccNum);
				System.out.printf("잔고 : %d\n", intBalance);
				System.out.println("===================");
			} else {
				System.out.println("계좌번호가 없음!!");
			}
		} else if(intMenu ==2 ) {
			System.out.println("입금처리");
			/*
			 * 1.계좌번호 입력
			 * 2.계좌번호 일치하면 입금액 입력
			 * 3. 계좌잔액 = 입금액 + 계좌잔액
			 */
			System.out.print("계좌번호>>");
			String strAccKeyIn = scanner.nextLine();
			if(strAccKeyIn.equals(strAccNum)) {
				
				System.out.println("==================");
				System.out.printf("계좌번호: %s\n",strAccNum);
				System.out.printf("잔고 : %d\n", intBalance);
				System.out.println("===================");
				System.out.print("입금액>>");
				String strInput = scanner.nextLine();
				int intInput = Integer.valueOf(strInput);
				intBalance += intInput;
			} else {
				System.out.println("계좌번호가 없음!!");
			}
		
		} else if(intMenu ==3) {
			System.out.println("출금처리");
			/*
			 * 1.계좌번호 입력
			 * 2.일치하면 출금금액 입력
			 * 3.잔액(잔고) >= 출금금액 이면 출금처리
			 * 4.잔액(잔고) < 출금금액 이면 출금거부
			 */
			System.out.print("계좌번호>>");
			String strAccKeyIn = scanner.nextLine();
			if(strAccKeyIn.equals(strAccNum)) {
				System.out.println("==================");
				System.out.printf("계좌번호: %s\n",strAccNum);
				System.out.printf("잔고 : %d\n", intBalance);
				System.out.println("===================");
				System.out.print("출금액>>");
				String strOutput = scanner.nextLine();
				int intOutput = Integer.valueOf(strOutput);
				if(intBalance >= intOutput) {
					intBalance -= intOutput ;
				} else {
					System.out.println("잔액부족!! 출금불가!!");
				}
			} else {
				System.out.println("계좌번호가 없음!!");
			}
		}
	}
}
