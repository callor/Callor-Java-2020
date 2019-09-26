package com.biz.pay;

import com.biz.pay.service.PayServiceV1;

/*
 * 반복문을 사용하여 화폐매수를 계산하시오
 * 1. 화폐 권종을 배열로 선언하여 계산하는 방법
 * 	 화폐 권종이 불규칙적인 경우 사용하는 방버
 */
public class PayMent_01 {

	public static void main(String[] args) {
		int pay = 3785870;
		PayServiceV1 ps = new PayServiceV1();
		ps.array(pay);

		
		
	}

}
