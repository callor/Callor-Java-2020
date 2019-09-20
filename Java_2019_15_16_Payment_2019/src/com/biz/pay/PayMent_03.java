package com.biz.pay;

import com.biz.pay.service.PayServiceV5;

public class PayMent_03 {

	public static void main(String[] args) {

		PayServiceV5 ps = new PayServiceV5();
		
		int nPay = 3929390;
		 ps.array(nPay);
		 // ps.whilePay(nPay);
		 ps.forPay(nPay);
	}

}
