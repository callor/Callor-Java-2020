package com.callor.blackjack.exec;

import java.util.List;
import java.util.Scanner;

import com.callor.blackjack.domain.DeckVO;
import com.callor.blackjack.service.DeckService;
import com.callor.blackjack.service.PlayerService;

public class BlackExec01 {

	public static void main(String[] args) {

		DeckService deck = new DeckService();

		// Deck 생성
		deck.makeDeck();
		// bs.viewCardList();
		List<DeckVO> deckList = deck.getDeck();
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("==============================");
			System.out.println(" Game Start");
			System.out.println("==============================");
			PlayerService dealer = new PlayerService(deckList, "딜러");
			PlayerService player = new PlayerService(deckList);

			// 게임시작 각각 2장의 카드 선 지급
			for (int i = 0; i < 2; i++) {
				dealer.hit();
				player.hit();
			}

			// 딜러는 점수합이 16이하이면 반드시 카드를 한장 추가로 뽑는다.
			if (dealer.sumValue() < 17)
				dealer.hit();

			while (true) {
				System.out.println("=============================");
				System.out.println("1.Hit   2.Stand   0.GameEnd");
				System.out.println("-----------------------------");
				System.out.print("선택 >> ");
				String strKey = scan.nextLine();

				int intKey = Integer.valueOf(strKey);

				if (intKey == 0) {
					System.out.println("Good Bye!!!");
					return;
				}

				if (intKey == 1) {
					dealer.hit();
					player.hit();
				}
				int dealerSum = dealer.sumValue();
				int playerSum = player.sumValue();

				if (playerSum > 21) {
					System.out.println("딜러 승리!!");
					break;
				} else if (dealerSum > 21) {
					System.out.println("플레이어 승리!!");
					break;
				}

				if (intKey == 2) {
					if (dealerSum > playerSum) System.out.println("딜러승리!!");
					else System.out.println("플레이어 승리!!");

					System.out.println("아무키나 누르세요.....");
					break;
		
				}

			}
			scan.nextLine();
		}
		
		
		// scan.close();


	}

}