package com.biz.pay.service;

public class PaperMakeServiceV1 {

	public void make(int pay) {
		
		int money = 50000;
		int sw = 1;
		
		while(true) {
			
			if(pay < 5) break;
			int count = (int)(pay / money);
			
			System.out.printf("%d원권 : %d",money,count);
			
			pay -= (count * money);
			if(sw > 0)
				money /= 5;
			else
				money /= 2;
			sw *= (-1);
		}		
	}
	
}
