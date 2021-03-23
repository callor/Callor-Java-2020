package com.biz.pay;

import com.biz.pay.service.PayService;
import com.biz.pay.service.PayServiceV6;

public class PayMent_04 {

	public static void main(String[] args) {

		PayService ps = new PayServiceV6();
		
		int nPay = 3723560;
		 ps.forPay(nPay);
	}

}
