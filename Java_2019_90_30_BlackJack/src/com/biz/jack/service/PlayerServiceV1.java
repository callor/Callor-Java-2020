package com.biz.jack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.jack.domain.DeckVO;

public class PlayerServiceV1 {

	// 각 플레이어(딜러포함)가 받은 카드를 저장할 List
	List<DeckVO> myDeckList;
	
	// deck에서 한장씩 플레이어에게 전달할 카드 들
	List<DeckVO> pubDeckList;
	String playerName ;
	
	public PlayerServiceV1(List<DeckVO> deckList) {
		this(deckList,"딜러");
	}
	
	public PlayerServiceV1(List<DeckVO> deckList, String playName) {

		this.myDeckList = new ArrayList<DeckVO>();
		this.pubDeckList = deckList;
		this.playerName = playName;
		
	}
	
	// 자신이 받은 카드의 점수를 계산하는 method
	public int sumValue() {
		int sumValue = 0;
		for(DeckVO vo : myDeckList) {
			sumValue += vo.getValue();
		}
		return sumValue;
	}
	
	// 각 player들이 hit를 했을때 수행할 method
	public void hit() {
		
		if(this.playerName.equals("딜러") && this.sumValue() > 16) {
			System.out.println("딜러점수 : " + this.sumValue());
			System.out.println("딜러 Hit 금지!!");
		} else {
			// 받은 카드를 내 카드 리스트에 추가
			myDeckList.add(pubDeckList.get(0));
			
			// 받을 카드에서 첫번 1장을 제외
			pubDeckList.remove(0);
		}
		
		System.out.println("==============================");
		System.out.println(playerName);
		System.out.println("------------------------------");
		
		// 현재 보유중인 카드 리스트를 보여주기
		for(DeckVO vo : myDeckList) {
			System.out.println(vo);
		}
		System.out.println("------------------------------");
		System.out.println("현재점수 : " + this.sumValue());
	}
}
