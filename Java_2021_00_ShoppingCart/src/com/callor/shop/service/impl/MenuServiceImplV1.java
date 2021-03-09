package com.callor.shop.service.impl;

import java.util.Scanner;

import com.callor.shop.config.Values;
import com.callor.shop.service.MenuService;

public class MenuServiceImplV1 implements MenuService {

	private final Scanner scan;

	public MenuServiceImplV1() {
		this.scan = new Scanner(System.in);
	}

	@Override
	public Integer selectMenu() {
		while(true) {
			System.out.println(Values.dLine);
			System.out.println("빛나라 쇼핑몰 System V2021");
			System.out.println(Values.sLine);
			System.out.println("1. 장바구니 상품 담기");
			System.out.println("2. 장바구니 전체 리스트 보기");
			System.out.println("3. 구매자별 장바구니 리스트 보기");
			System.out.println("4. 장바구니 파일에 저장");
			System.out.println("5. 장바구니 파일에서 불러오기");
			System.out.println("QUIT. 끝내기");
			System.out.println(Values.dLine);
			System.out.print("선택 >> ");
			String strMenu = scan.nextLine();
			if(strMenu.equals("QUIT")) {
				return null;
			}
			try {
				Integer intMenu = Integer.valueOf(strMenu);
				if(intMenu < 1 || intMenu > 5) {
					System.out.println("업무 선택은 1 ~ 5까지 중에 선택하세요");
					continue;
				}
				return intMenu;
			} catch (Exception e) {
				System.out.println("업무 선택은 QUIT(끝내기), 1 ~ 5까지 정수만 입력할 수 있습니다");
			}
		}
	}
}