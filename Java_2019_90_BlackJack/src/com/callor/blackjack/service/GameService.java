package com.callor.blackjack.service;

import java.util.List;
import java.util.Scanner;

import com.callor.blackjack.domain.DeckVO;
import com.callor.blackjack.utils.BlackJackUtils;

public class GameService {

	DeckService deck = new DeckService();
	List<DeckVO> deckList;
	Scanner scan;

	public GameService() {
		// Deck 생성
		deck.makeDeck();
		// bs.viewCardList();
		deckList = deck.getDeck();
		scan = new Scanner(System.in);
	}

	public void gameStart() {
		System.out.println(BlackJackUtils.getStringLong("=", 100));
		System.out.println(" Game Start");
		System.out.println(BlackJackUtils.getStringLong("=", 100));
		
		PlayerService dealer = new PlayerService(deckList, "딜러");
		PlayerService player = new PlayerService(deckList);

		// 게임시작 각각 2장의 카드 선 지급
		for (int i = 0; i < 2; i++) {
			dealer.hit();
			player.hit();
		}

		// 딜러는 점수합이 16이하이면 반드시 카드를 한장 추가로 뽑는다.
		if (dealer.sumValue() < 17) dealer.hit();

	}

}
