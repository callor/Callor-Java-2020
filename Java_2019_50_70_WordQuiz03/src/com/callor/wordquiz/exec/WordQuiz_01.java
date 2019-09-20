package com.callor.wordquiz.exec;

import com.callor.wordquiz.service.WordService;

public class WordQuiz_01 {

	public static void main(String[] args) {

		WordService ws = new WordService();
		// ws.viewWord();
		while (true) {
			if (ws.input()) {
				break;
			}
		}
		System.out.println("GAME OVER !!!");

	}

}
