package com.callor.word.exec;

import com.callor.word.service.WordService;
import com.callor.word.service.impl.WordServiceImplV1;

public class WordEx_01 {
	
	
	public static void main(String[] args) {
		WordService wService = new WordServiceImplV1();
		wService.startGame();
	}

}
