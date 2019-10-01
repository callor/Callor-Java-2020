package com.biz.pay.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.pay.domain.PaperVO;

public class PaperMakeServiceV2 {

	private List<PaperVO> paperList;
	
	// 외부에서 paperList를 가져가도록 열어주는 통로
	public List<PaperVO> getPaperList() {
		return paperList;
	}
	
	public void make(int pay) {
		
		paperList = new ArrayList<PaperVO>();
		
		int money = 50000;
		int sw = 1;
		
		while(true) {
			
			if(pay < 5) break;
			int count = (int)(pay / money);
			
			// 생성자 method에 필드세팅값을 주입하면서
			// 객체 인스턴스를 생성
			PaperVO pVO = new PaperVO(money+ "",count);
			//pVO.setPaper(money);
			//pVO.setCount(count);
			paperList.add(pVO);
			
			// System.out.printf("%d원권 : %d",money,count);
			// paperVO에 값을 setting
			// paperList에 추가
			
			pay -= (count * money);
			if(sw > 0)
				money /= 5;
			else
				money /= 2;
			sw *= (-1);
		}		
	}
	
}
