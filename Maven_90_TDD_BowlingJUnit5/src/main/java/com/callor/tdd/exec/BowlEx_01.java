package com.callor.tdd.exec;

import com.callor.tdd.BowllGame;

public class BowlEx_01 {

	public static void main(String[] args) {
		
		BowllGame bg = new BowllGame();
		
		//			   1 2 3 4 5 6 7 8 9 10	
		String game = "XXXXXXXXXXXX";
		game = "X5*3*5*525-";
		String[] games = game.split("");
		
		int preGame = 10;
		for(String g : games) {
			int thisGame = 0;
			if(g.equalsIgnoreCase("X")) {
				thisGame = 10;
			} else if(g.equals("*")) {
				thisGame = 10 - preGame;
				
			}else if (g.equals("-")) {
				thisGame = 0;
			} else {
				thisGame = Integer.valueOf(g); 
			}
			System.out.println(thisGame);
			bg.roll(thisGame);
			preGame = thisGame;
		}
		
		System.out.println(bg.score());
		
	}
	
	
}
