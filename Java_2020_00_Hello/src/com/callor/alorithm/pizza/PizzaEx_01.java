package com.callor.alorithm.pizza;

import java.util.Random;

public class PizzaEx_01 {
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		int intMembers = rnd.nextInt(26) + 25;
		int pizzaPcs = 6;
		
		int pizzaBox = intMembers / pizzaPcs;
		
		if(intMembers % pizzaPcs != 0) {
			pizzaBox++;
		}
		
		System.out.println("===========================");
		System.out.println("학생수 : " + intMembers);
		System.out.println("주문 개수 : " + pizzaPcs);
		System.out.println("주문 피자 : " + pizzaBox);
		System.out.println("--------------------------");
		System.out.println("총 PCS : " + (pizzaBox * pizzaPcs));
		
		
		
		
		
	}

}
