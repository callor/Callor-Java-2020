package com.callor.menu;

import java.util.Scanner;

public class MenuServiceV1 {

	public int selectMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("====================================");
			System.out.println("Java Menu System v1");
			System.out.println("------------------------------------");
			
			System.out.println("1. 메뉴1");
			System.out.println("2. 메뉴1");
			System.out.println("3. 메뉴1");
			System.out.println("4. 메뉴1");
			System.out.println("5. 메뉴1");
			System.out.println("Q. 끝내기");
			System.out.println("------------------------------------");
			System.out.print("선택 >> ");
			String strMenu = scan.nextLine();
			if(strMenu.equals("Q")) {
				return -1;
			}
			Integer intMenu = 0;
					
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴 선택은 Q:(끝내기), 1 ~ 5까지 정수만 입력해야 합니다");
			}
			return intMenu;
			
		}
		
	}
	
	
}
