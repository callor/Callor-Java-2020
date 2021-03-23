package com.callor.alorithm.service;

import java.util.Random;

public class PizzaServiceV1 {
	
	private final Random rnd;
	private Integer pizzaPcs;
	private Integer intMembers[];
	private Integer pizzaOrders[];
	public PizzaServiceV1() {
		this.rnd = new Random();
		this.pizzaPcs = 6;
	}
	
	public void makeMembers(int intMember) {
		this.intMembers = new Integer[intMember];
		this.pizzaOrders = new Integer[intMember];
		
		for(int i = 0 ; i < intMembers.length ; i++) {
			intMembers[i] = rnd.nextInt(10) + 50;
		}
	}
	
	public void pizzsOrders() {
		for(int i = 0 ; i < intMembers.length ; i++) {
			pizzaOrders[i] =  intMembers[i] / pizzaPcs;
			if(intMembers[i] % (pizzaOrders[i] * pizzaPcs) > 0) {
				pizzaOrders[i]++;
			}
		}
	}
	
	public void printOrders() {
		
		int pizzaTotal = 0;
		System.out.println("=====================================");
		System.out.println("인원수\t피자주문\t전체조각수");
		System.out.println("-------------------------------------");
		for(int i = 0 ; i < intMembers.length ; i++) {
			
			System.out.printf("%6d\t",intMembers[i]);
			System.out.printf("%8d\t",pizzaOrders[i]);
			System.out.printf("%10d\n",pizzaOrders[i] * pizzaPcs);
			pizzaTotal += pizzaOrders[i];
			
		}
		System.out.println("--------------------------------------");
		System.out.printf("전체 주문 BOX 수량 : %d\n",pizzaTotal);
		System.out.println("======================================");
		
		
	}
	

}
