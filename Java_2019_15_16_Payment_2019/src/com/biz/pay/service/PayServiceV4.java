package com.biz.pay.service;

public class PayServiceV4 extends PayServiceV2{
	
	@Override
	public void whilePay(int nPay) {
		
		this.headerView(nPay);
		
		int intSw = 1;
		
		// while(참인조건) {  }
		// 참인조건을 만족하는 동안 {  } 코드를 실행해라
		
		/*
		 * 조건문(if, while, for)을 코딩할때
		 * 부등호(<>)와 EQ(=)를 같이 사용해야할 조건문을
		 * 부등호만 사용해서 만들수 있다면
		 * 부등호만 사용해서 코딩을 해라
		 */
		// while(nPay >= 5) { 
		while(nPay > 1) { // 5원일 경우 수행이 될까요? yes
			
			
			// 5원일 경우 수행이 될까요? yes
			// if(nPay < 5) break; 
			
			int nCount = nPay / nMoney ; // 매수계산
			nPay -= nCount * nMoney; // nPay = nPay - nCount * nMoney
			System.out.printf("%8s 원권 %4d매\n",
					paperForm.format(nMoney),
					nCount);

			if(intSw == 1) {
				nMoney /= 5; // nMoney = nMoney / 5
			} else {
				nMoney /= 2; // nMoney = nMoney / 2
			}
			intSw = intSw * (-1);
		
		}
		System.out.println("=====================");
		
	}
}
