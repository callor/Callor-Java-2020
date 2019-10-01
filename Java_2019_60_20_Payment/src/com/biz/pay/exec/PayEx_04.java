package com.biz.pay.exec;

import java.util.List;

import com.biz.pay.domain.PaperVO;
import com.biz.pay.service.PaperMakeServiceV2;

public class PayEx_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PaperMakeServiceV2 pm = new PaperMakeServiceV2();
		
		pm.make(3758790);
		List<PaperVO> paperList = pm.getPaperList();
		
		// paperWriter에게 주입

	}

}
