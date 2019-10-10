package com.callor.pay.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.pay.domain.PaperVO;

/*
 * 급여액에 대한 화폐매수를 계산을 하고
 * 그 결과를 List에 담도록 설정
 */
public class PaperMakeServiceV1 {

	List<PaperVO> paperList;
	
	public List<PaperVO> getPaperList() {
		return this.paperList;
	}
	
	/*
	 * 외부에서 급여액을 매개변수로 주입받고
	 * 화폐매수를 계산한 다음 List에 담기
	 */
	public void make(int pay) {
		
		paperList = new ArrayList<PaperVO>();
		int paper = 50000; // 대한민국 화폐의 최고단위 액면가
		int sw = 1;
		
		// 무한반복문을 실행해서 화폐매수를 계산 수행
		while(true) {

			if(pay < 5) break;
			
			//1. paper 액면가에 대한 화폐매수를 계산
			// pay 에 포함된 paper의 매수
			int paperCount = (int)(pay / paper);
			
			// PaperVO에 일단 담기
			PaperVO pVO = new PaperVO();
			pVO.setPaper(paper + ""); // 액면가
			pVO.setCount(paperCount); // 매수
			
			// pVO를 paperLits에 담기
			paperList.add(pVO);
			
			pay -= (paper * paperCount);
			
			// 최초에 5만원, 1만원, 5천원 순서로 액면가를 계산하고
			// 각 액면가에 대한 매수를 계산해야 하기 때문에
			// paper 변수를 5만원에서 1만원 되도록 계산을 수행
			if(sw > 0) {
				paper /= 5;
			} else {
				paper /= 2;
			}
			sw *= (-1); // 1, -1. 1, -1 계속변화
			
			// 최초 pay에서 액면가를 계산한 후
			// 액면가 금액만큼을 삭제해서
			// 이후 액면가 매수를 계산하도록 수행
			
		}
	}
	
}
