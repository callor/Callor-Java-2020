package com.callor.alorithm;

import com.callor.alorithm.service.PizzaServiceV1;

public class PizzaEx_02 {
	
	
	public static void main(String[] args) {
		
		PizzaServiceV1 pV1 = new PizzaServiceV1();
		
		pV1.makeMembers(5);
		pV1.pizzsOrders();
		pV1.printOrders();
		
	}

}
