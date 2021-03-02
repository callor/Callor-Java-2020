package com.callor.menu;



public class MenuExec {

	public static void main(String[] args) {
		
		MenuService mService = new MenuServiceImplV1();
		
		while(true) {
			Integer intMenu = mService.selectMenu();
			if(intMenu == -1) {
				break;
			}
			System.out.println("선택된 메뉴 : " + intMenu);
		}
		System.out.println("빛나라 시스템을 종료합니다!!!");
		
	}
	
}
