package com.callor.wordquiz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordService {

	public int count;
	private List<String> wordList;
	private String word;
	private List<String> words;
	
	private Scanner scan;
	
	public WordService() {

		scan = new Scanner(System.in);
		
		wordList = new ArrayList<String>();
		wordList.add("yesterday");
		wordList.add("morning");
		wordList.add("tomorrow");
		wordList.add("school");
		wordList.add("computer");
		wordList.add("human");

		wordList.add("foot");
		wordList.add("person");
		wordList.add("leaf");
		wordList.add("mouse");
		wordList.add("goose");
		wordList.add("half");
		wordList.add("knife");
		wordList.add("wife");
		wordList.add("life");
		wordList.add("elf");
		wordList.add("loaf");
		wordList.add("potato");
		wordList.add("tomato");
		wordList.add("cactus");
		wordList.add("focus");
		wordList.add("fungus");
		wordList.add("nucleus");
		wordList.add("syllabus");
		wordList.add("analysis");
		wordList.add("diagnosis");
		wordList.add("oasis");
		wordList.add("thesis");
		wordList.add("crisis");
		wordList.add("phenomenon");
		wordList.add("criterion");
		wordList.add("datum");
		
		count = 0;
		
	}
	
	public void makeWord() {
		// 단어들 리스트를 뒤 섞기
		Collections.shuffle(wordList);
		
		// 뒤 섞인 단어 리스트에 0번째 단어만 추출
		word = wordList.get(0);
		
		// 추출된 단어를 알파벳 단위로 나누어 List로 변환
		words = Arrays.asList(word.split(""));
		
		// 알파벳 뒤 섞기
		Collections.shuffle(words);
	}
	
	public boolean input() {

		if(count < 1) { 
			this.makeWord();
		}
		
		System.out.println("=============================");
		System.out.println("단어맞추기 게임!!");
		System.out.println("-----------------------------");
		System.out.println("제시한 알파벳을 잘 배열하여");
		System.out.println("단어를 완성하시오");
		System.out.println("-----------------------------");
		System.out.println(words);
		System.out.println("-----------------------------");
		System.out.print("(-1:END) >> ");
		String strKeyIn = scan.nextLine();
		if(strKeyIn.equals("-1")) {
			return true;
		}
		
		if(strKeyIn.equalsIgnoreCase(word)) {
			System.out.println(count + "번만에 맞추었습니다");
			count = 0;
		} else {
			System.out.println("틀렸습니다");
			count++;
		}
		System.out.println("Press Any to Continue...");
		scan.nextLine();
		return false;
	
	}
	
}

