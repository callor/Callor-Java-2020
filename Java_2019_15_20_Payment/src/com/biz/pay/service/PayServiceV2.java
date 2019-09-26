package com.biz.pay.service;

import java.text.DecimalFormat;

public class PayServiceV2 extends PayServiceV1 {

	/*
	 * protected로 선언한 맴버 변수는
	 * 이 클래스(PayServiceV2)를 상속받은 클래스들에서
	 * 접근하여사용할수 있다.
	 */
	protected int nMoney = 50000;
	protected DecimalFormat paperForm 
			= new DecimalFormat("###,###");

	public PayServiceV2() {
		nMoney = 50000;
	}
	
	/*
	 * PayServiceV1에서 작성된 array(int nPay) method도
	 * 사용할수 있음...
	 */
	
	/*
	 * while 반복문을 사용해서 구현
	 */
	public void whilePay(int nPay) {
		
		int intSw = 0;

		
		this.headerView(nPay);
		
		while(true) {
		
			// 화폐매수 계산을 수행하는 과정에서
			// nPay 값을 검사하여 5원미만으로 금액 남으면
			// 더이상 연산을 수행하지 마라
			if(nPay < 5) break; 
			
			int nCount = nPay / nMoney ; // 매수계산
			nPay -= nCount * nMoney; // nPay = nPay - nCount * nMoney
			System.out.printf("%8s 원권 %4d매\n",
					paperForm.format(nMoney),
					nCount);
			if(intSw == 0) {
				nMoney /= 5; // nMoney = nMoney / 5
				intSw = 1;
			} else {
				nMoney /= 2; // nMoney = nMoney / 2
				intSw = 0;
			}
		
		}
		System.out.println("=====================");
	} // end whilePay()
	
	protected void headerView(int nPay) {
		
		DecimalFormat payform = new DecimalFormat("###,###,###,###");
		String strPay = payform.format(nPay);
		
		System.out.println("========================");
		System.out.printf("급여수령액 : %s\n",strPay);
		System.out.println("========================");
	
	}
	
}
