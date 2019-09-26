package com.biz.pay.service;

import java.text.DecimalFormat;

public class PayServiceV1 {
	private int[] money = new int[] {
			50000,
			10000,
			5000,
			1000,
			500,
			100,
			50,
			10
	};
	
	/*
	 * 화폐권종에 관계없이 권종을 배열로 선언하고
	 * 화폐매수를 계산하는 방법
	 */
	public void array(int nPay) {
		
		DecimalFormat payform = new DecimalFormat("###,###,###,###");
		String strPay = payform.format(nPay);
		
		DecimalFormat paperForm = new DecimalFormat("###,###");
		
		System.out.println("========================");
		System.out.printf("급여수령액 : %s\n",strPay);
		System.out.println("========================");

		for(int i = 0 ; i < money.length ; i++) {
			int nCount = nPay / money[i]; // 매수계산
			nPay = nPay - money[i] * nCount; // 권종*개수 만큼 빼기
			System.out.printf("%8s 원권 %4d매\n",
					paperForm.format(money[i]),
					nCount);
		}
		System.out.println("========================");
	
	}
}
