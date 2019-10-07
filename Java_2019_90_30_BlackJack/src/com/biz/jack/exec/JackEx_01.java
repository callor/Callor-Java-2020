package com.biz.jack.exec;

import java.util.List;

import com.biz.jack.service.DeckServiceV1;
import com.callor.jack.domain.DeckVO;

public class JackEx_01 {

	public static void main(String[] args) {

		DeckServiceV1 deck = new DeckServiceV1();
		
		deck.makeDeck();
		List<DeckVO> deckList = deck.getDeck();
		for(DeckVO vo : deckList) {
			System.out.println(vo);
		}
		
	}

}
