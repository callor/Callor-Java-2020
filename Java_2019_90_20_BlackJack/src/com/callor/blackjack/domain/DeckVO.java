package com.callor.blackjack.domain;

/*
 * 플레잉카드(playing card)는 손에 잡히는 크기의 두꺼운 종이나 얇은 플라스틱으로 만들어진다. 
 * 트럼프(trump)라고 불리기도 하는데 이는 카드패 중의 으뜸패를 가리키는 말이다. 
 * 한 묶음의 카드를 카드 한 벌 혹은 한 덱(deck)이라고 한다. 
 * 카드는 놀이와 도박에 주로 사용되고 마술이나 점(占), 카드쌓기 놀이로도 사용된다.
 * 
 * 일반적으로 카드 한 벌(deck)은 52개이며, 
 * 모양별로 4종류의 슈트로 나뉜다. 
 * 빨간 슈트는 다이아몬드 (◆)와 하트(♥), 검은 슈트는 스페이드(♠)와 클로버(♣)이다. 
 * 네 종류의 각 슈트마다 다음과 같이 13개의 끗수(denomination)를 나타내는 숫자 
 * 혹은 알파벳이 적혀 있다: 2, 3, 4, 5, 6, 7, 8, 9, 10, J(jack), Q(queen), K(king), A(ace)
 *  
 */

public class DeckVO {
	
	private String suit;
	private String denomination;
	private int value;
	
	public DeckVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeckVO(String suit, String denomination, int value) {
		super();
		this.suit = suit;
		this.denomination = denomination;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}



	@Override
	public String toString() {
		return "[suit=" + suit + "\t\tdenomination=" + denomination + "\tvalue=" + value + "]";
	}
	

	
	
}
