package com.biz.jack.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.callor.jack.domain.DeckVO;

/*
 * 게임에서 사용할 1벌의 게임카드를 생성
 */
public class DeckServiceV1 {

	// 생성된 1벌의 카드를 List에 저장
	List<DeckVO> deckList;
	String suit = "다이아몬드(◆):하드(♥):스페이드(♠):클로버(♣)";
	String[] arrSuit = new String[]
			{
				"다이아몬드(◆)",
				"하드(♥)",
				"스페이드(♠)",
				"클로버(♣)"
			};
	
	String denomination = "A234567890KQJ";

	public DeckServiceV1() {
		this.deckList = new LinkedList<DeckVO>();
	}
	
	public List<DeckVO> getDeck() {
		int nSize = deckList.size();
		for(int i = 0 ; i < nSize ; i++) {
			Collections.shuffle(this.deckList);
		}
		
		for(DeckVO vo : deckList) {
			Collections.shuffle(this.deckList);	
		}
		
		return this.deckList;
	}
	
	public void makeDeck() {
		
		String[] denoms = denomination.split("");
		for(String suit : arrSuit) {
			for(String denom : denoms) {
				
				// 각 카드가 갖게될 value를 생성
				// value값은 denoms를 기준으로 생성
				// 2~9까지는 보이는 값 그대로
				// A는 1로 JQK는 10으로
				
				int intValue = 0;
				
				try {
					// 숫자 2~90까지는 각각 값들이 정수로
					// 정상 변환이 될것이다.
					// 하지만 A, JKQ는 Exception이 발생을 할 것이다
					intValue = Integer.valueOf(denom);
					if(intValue == 0) intValue =  10;
				} catch (Exception e) {
					if(denom.equals("A")) intValue = 1;
					else intValue = 10; // JKQ일때
				}

				DeckVO dVO = new DeckVO();
				dVO.setSuit(suit);
				dVO.setDenomination(denom);
				dVO.setValue(intValue);
				deckList.add(dVO);
			}
		}
	}
	
	


}
