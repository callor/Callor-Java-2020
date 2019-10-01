package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.domain.DeckVO;
import com.callor.blackjack.utils.BlackJackUtils;

public class PlayerService {

	private String playerName = "플레이어";
	private List<DeckVO> playList;
	private List<DeckVO> deckList;
	private int sumValue = 0;

	public PlayerService(List<DeckVO> deckList) {
		this(deckList, "플레이어");
	}

	public PlayerService(List<DeckVO> deckList, String playerName) {
		this.playList = new ArrayList<DeckVO>();
		this.deckList = deckList;
		this.playerName = playerName;
	}

	public int sumValue() {
		sumValue = 0;
		for (DeckVO vo : playList) {
			sumValue += vo.getValue();
		}
		return sumValue;
	}

	public void hit() {

		if (playerName.equals("딜러") && sumValue > 16) {
			System.out.println("딜러점수 : " + sumValue);
			System.out.println("딜러 Hit 금지");
		} else {
			playList.add(deckList.get(0));
			deckList.remove(0);
		}

		System.out.println(BlackJackUtils.getStringLong("=", 100));
		System.out.println(playerName);
		System.out.println(BlackJackUtils.getStringLong("-", 100));

		for (DeckVO vo : playList) {
			System.out.println(vo);
		}

		sumValue();
		System.out.println("현재점수 : " + sumValue);

	}

}