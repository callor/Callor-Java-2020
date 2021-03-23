package com.biz.pay;

import com.biz.pay.service.PayService;
import com.biz.pay.service.PayServiceV7;

public class PayMent_05 {

	public static void main(String[] args) {

		PayService ps = new PayServiceV7();
		
		int nPay = 3723560;
		 ps.whilePay(nPay);
	}

}
