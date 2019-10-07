package com.callor.pay.exec;

import java.io.IOException;
import java.util.List;

import com.callor.pay.service.PayReadServiceV1;

public class PayEx_01 {

	public static void main(String[] args) {

		String payFile = "src/com/biz/pay/pay.txt";
		PayReadServiceV1 pr = new PayReadServiceV1();
		
		try {
			// 내부에서 payStrList를 생성해 둘것이다.
			pr.readPay(payFile);
			
			// payStrList를 가져와서 사용하자
			List<String> payStrList = pr.getPayStrList();
			
			for(String str : payStrList) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
