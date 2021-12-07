package com.callor.shop;

import com.callor.shop.service.CartService;
import com.callor.shop.service.MenuService;
import com.callor.shop.service.impl.CartServiceImplV1;
import com.callor.shop.service.impl.MenuServiceImplV1;

public class CartEx_01 {

	public static void main(String[] args) {
		
		MenuService mService = new MenuServiceImplV1();
		CartService cService = new CartServiceImplV1();
		
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
			}
		}
	}
}
