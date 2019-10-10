package com.callor.pay.exec;

import java.io.IOException;
import java.util.List;

import com.callor.pay.domain.PaperVO;
import com.callor.pay.service.PaperMakeServiceV1;
import com.callor.pay.service.PaperPrintServiceV1;

public class PayEx_03 {

	public static void main(String[] args) {

		PaperPrintServiceV1 pp = new PaperPrintServiceV1();
		String payFile = "src/com/biz/pay/pay.txt";
		
		pp.setPayFile(payFile);
		try {
			pp.makePaperList();
			pp.viewPaper();
			pp.printPaper();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
