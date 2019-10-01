package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.callor.blackjack.domain.DeckVO;

public class DeckService {
	
	
	private List<DeckVO> deckList ;
	private String suit = "다이아몬드(◆):하트(♥):스페이드(♠):클로버(♣)";
	private String denomination = "A1234567890KQJ";
	
	public DeckService() {
		deckList = new ArrayList<DeckVO>();
	}
	
	public List<DeckVO> getDeck() {
		for(int i = 1 ; i < 50 ; i++) {
			Collections.shuffle(deckList);	
		}
		return this.deckList;
	}
	
	public void makeDeck() {
		String[] suits = suit.split(":");
		String[] denoms = denomination.split("");
		
		for(String s : suits) {
			for(String d : denoms) {
				
				DeckVO vo = new DeckVO() ;
				vo.setSuit(s);
				vo.setDenomination(d);
				
				int intValue = 0;
				
				try {
					intValue = Integer.valueOf(d);
					if(intValue == 0) intValue = 10;
				} catch (Exception e) {
					if(d.equals("A")) {
						intValue = 1;
					} else {
						intValue = 10;
					}
				}
				vo.setValue(intValue);
				deckList.add(vo);
			}
		}
	}
	
	public void viewCardList() {
		for(DeckVO d : deckList) {
			System.out.println(d);
		}
		System.out.println("Size:" + deckList.size());
	}

}
