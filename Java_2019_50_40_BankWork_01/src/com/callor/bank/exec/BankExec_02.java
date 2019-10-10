package com.callor.bank.exec;

import java.util.Scanner;

import com.callor.bank.service.BankServiceV1;

public class BankExec_02 {

	public static void main(String[] args) {

		BankServiceV1 bs = null;
		Scanner scanner = new Scanner(System.in);

		// 계좌번호
		String strAccNum = "0001";
		// balance : 잔고(예금잔고)
		int intBalance = 100000;
		
		// 계좌번호가 0001이고, 잔고가 100000인 
		// 새로운 계좌 인스턴스를 만들어라
		bs = new BankServiceV1(strAccNum,intBalance);
		while(true) {
			System.out.println("============================");
			System.out.println("광한루 은행");
			System.out.println("============================");
			System.out.println("1.조회 2.입금 3.출금 0.종료");
			System.out.println("----------------------------");
			System.out.print("선택>>");
			String strMenu = scanner.nextLine();
			int intMenu = Integer.valueOf(strMenu);
			if(intMenu == 0) break;
			else if(intMenu == 1) {
				// 계좌조회
				bs.viewAcc();
			} else if(intMenu == 2) {
				// 입금처리
				bs.viewAcc();
				bs.input();
			} else if(intMenu == 3) {
				// 출금처리
				bs.viewAcc();
				bs.output();
			}
		}
		System.out.println("업무종료!!!");
		

	}

}
