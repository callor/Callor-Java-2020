package com.callor.bank.exec;

import java.util.Scanner;

import com.callor.bank.service.BankService;
import com.callor.bank.service.BankServiceImplV2;

public class BankEx_01 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		BankService bService = new BankServiceImplV2();
		
		while(true) {
			
			System.out.println("==================================");
			System.out.println("빛고을 뱅크 계정계 시스템 V1");
			System.out.println("==================================");
			System.out.println("1. 입금처리");
			System.out.println("2. 출금처리");
			System.out.println("3. 입출금 내역 출력");
			System.out.println("-1. 업무종료");
			System.out.println("==================================");
			System.out.print("업무선택 >> ");
			
			String strMenu =  scan.nextLine();
			int intMenu = 0;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴선택은 숫자로만 입력하세요");
				continue;
			}
 			if(intMenu == -1) {
 				break;
 			} else if(intMenu == 1) {
 				// 입금업무처리
 				bService.inputBalance();
 			} else if(intMenu == 2) {
 				//  출금업무처리
 				bService.outputBalance();
 			} else if(intMenu == 3) {
 				// 입출금내역서 출력
 				bService.listBalance();
 			} else {
 				System.out.println("선택된 업무가 없습니다");
 			}
		}
	}
	
}
