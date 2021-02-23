package com.callor.score;

public class ScoreEx_01 {

	
	public static void main(String[] args) {
		
		ScoreServiceV1 ssV1 = new ScoreServiceV1();
		while(true) {
			
			int menu = ssV1.menu();
			System.out.println("선택된 메뉴 번호 : " + menu);
			if(menu == 1) {
				ssV1.rndScore();
				
			} else if (menu == 2) {
				ssV1.print();
			}
		}
	}
}
