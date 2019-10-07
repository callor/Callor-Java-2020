package com.callor.pay.exec;

import java.util.List;

import com.callor.pay.domain.PaperVO;
import com.callor.pay.service.PaperMakeServiceV1;

public class PayEx_02 {

	public static void main(String[] args) {

		PaperMakeServiceV1 pm = new PaperMakeServiceV1();
		
		// 내부에서 전달받은 급여금액 3786790원에 대한
		// 화폐매수를 계산하여 paperList에 담고 있을 것이다
		pm.make(3786790);
		
		List<PaperVO> paperList = pm.getPaperList();
		for(PaperVO vo : paperList) {
			System.out.printf("%s\t%d\n",vo.getPaper(),vo.getCount());
		}
		
		
		
	}

}
