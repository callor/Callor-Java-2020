package com.callor.bank.exec;

import java.util.Scanner;

import com.callor.bank.service.BankAccServiceV1;

public class BankAccEx_01 {
	
	public static void main(String[] args) {
		BankAccServiceV1 bs = new BankAccServiceV1("0001",10000);
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("==============================");
			System.out.println("대한은행 계정계 v1.0");
			System.out.println("==============================");
			System.out.println("1. 조회 2.입금 3.출금 0.종료");
			System.out.println("------------------------------");
			System.out.print("업무선택>>");
			String strMenu = scanner.nextLine();
			int intMenu = Integer.valueOf(strMenu);
			if(intMenu == 0) break;
			else if(intMenu == 1) {
				bs.viewAcc();	
			} else if(intMenu == 2) {
				bs.input();
			} else if(intMenu == 3) {
				bs.output();
			}
		}
		System.out.println("오늘도 수고했습니다 !!!");
	}
}
