package com.callor.menu;

import java.util.Scanner;

public class MenuServiceImplV1 implements MenuService {

	
	Scanner scan;
	public MenuServiceImplV1() {
		scan = new Scanner(System.in);
	}
	
	public int selectMenu() {
		
		while(true) {
			System.out.println("====================================");
			System.out.println("Java Menu System v1");
			System.out.println("------------------------------------");
			
			System.out.println("1. 카트추가");
			System.out.println("2. 카트삭제");
			System.out.println("3. 카트리스트");
			System.out.println("Q. 끝내기");
			System.out.println("------------------------------------");
			System.out.print("선택 >> ");
			String strMenu = scan.nextLine();
			Integer intMenu = MenuService.MENU_QUIT;
			
			if(strMenu.equals("Q")) {
				return MenuService.MENU_QUIT;
			}
			try {
				intMenu = Integer.valueOf(strMenu);
				if(intMenu < 1 || intMenu > 5) {
					System.out.println("메뉴는 1 ~ 5까지 선택할 수 있습니다");
					continue;
				}
			} catch (Exception e) {
				System.out.println("메뉴 선택은 Q:(끝내기), 1 ~ 5까지 정수만 입력해야 합니다");
				continue;
			}
			return intMenu;
			
		}
		
	}
	
	
}
