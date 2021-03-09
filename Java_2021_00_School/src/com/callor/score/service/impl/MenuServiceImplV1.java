package com.callor.score.service.impl;

import java.util.Scanner;

import com.callor.score.service.MenuService;
import com.callor.score.values.Values;

public class MenuServiceImplV1 implements MenuService{

	private final Scanner scan;
	public MenuServiceImplV1() {
		scan = new Scanner(System.in);
	}
	
	@Override
	public Integer selectMenu() {

		while(true) {
			System.out.println(Values.dLine(50));
			System.out.println("빛나라 고료 성적처리 프로젝트 2021");
			System.out.println(Values.sLine(50));
			
			
			System.out.printf("%d. 성적데이터 생성\n",Values.MENU_MAKE);
			System.out.printf("%d. 성적데이터 저장\n",Values.MENU_SAVE);
			System.out.printf("%d. 성적리스트 출력\n",Values.MENU_PRINT);
			
			System.out.printf("%d. 학생 정보 검색\n",Values.MENU_STUDENT_SEARCH);
			
			System.out.println("QUIT. 업무종료");
			System.out.println(Values.sLine(50));
			System.out.print("선택>> ");
			String strMenu = scan.nextLine();
			if(strMenu.equals("QUIT")) {
				return null;
			}

			// int가 아닌 Integer로 선언
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.printf("◎ ◎ 메뉴는 QUIT, %d ~ %d 까지만 가능\n",Values.MENU_START,Values.MENU_LAST);
				continue;
			}
			if(intMenu >= Values.MENU_START && intMenu <= Values.MENU_LAST) {
				return intMenu;
			} else {
				System.out.printf("◎ ◎ 업무는 d ~ %d까지 중에서 선택\n",Values.MENU_START,Values.MENU_LAST);
			}
		}
	}

}
