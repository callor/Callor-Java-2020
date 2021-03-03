package com.callor.shop;

import com.callor.shop.service.CartService;
import com.callor.shop.service.MenuService;
import com.callor.shop.service.impl.CartServiceV1;
import com.callor.shop.service.impl.MenuServiceV1;

public class CartEx_01 {

	public static void main(String[] args) {
		
		MenuService mService = new MenuServiceV1();
		CartService cService = new CartServiceV1();
		
		while(true) {
			Integer intMenu = mService.selectMenu();
			System.out.println(intMenu);
			
			if(intMenu == null) {
				break;
			} else if(intMenu == 1) {
				cService.inputCart();
			} else if(intMenu == 2) {
				cService.printAllCart();
			} else if(intMenu == 3) {
				cService.printUserCart();
			} else if(intMenu == 4) {
				cService.saveCartToFile();

			} else if(intMenu == 5) {
				// 파일에서 불러오기
				cService.loadCartFromFile();
			}
		}
		
		
		
	}
	
	
}
