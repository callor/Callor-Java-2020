package com.biz.pay.exec;

import java.io.IOException;
import java.util.List;

import com.biz.pay.service.PaperPrintServiceV1;
import com.biz.pay.service.PaperReadServiceV1;

public class PayEx_05 {

	public static void main(String[] args) {
		String payFile = "src/com/biz/pay/pay.txt";
		
		PaperReadServiceV1 pr = new PaperReadServiceV1();
		PaperPrintServiceV1 pp = new PaperPrintServiceV1();
		try {
			pr.read(payFile);
			List<String> payStrList = pr.getPayStrList();
			pp.setPayStrList(payStrList);
			pp.print();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
