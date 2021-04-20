package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.GameVO;
import com.callor.word.model.WordVO;
import com.callor.word.service.Values;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	protected Scanner scan;
	protected Random rnd;
	
	protected List<WordVO> wordList;
	
	protected String basePath;
	protected GameVO score;
	

	public WordServiceImplV1() {

		scan = new Scanner(System.in);
		rnd = new Random();
		
		score = new GameVO();
		basePath = "src/com/callor/word/";
		wordList = new ArrayList<WordVO>();

	}

	public void startGame() {
		
		this.loadWords(basePath + "word.txt");
		int index = rnd.nextInt(wordList.size());
		score.setWordVO(wordList.get(index));
		
	}

	protected String[] suffleWord(String word) {
		
		String[] words = word.split("");
		for(int i = 0 ; i < 1000 ; i++) {
			int index1 = rnd.nextInt(words.length);
			int index2 = rnd.nextInt(words.length);
			
			String s = words[index1];
			words[index1] = words[index2];
			words[index2] = s;
		}
		return words;
	}
	
	protected void saveGame() {
		while (true) {
			System.out.println("저장할 파일이름 입력");
			System.out.print(">> ");
			String fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("파일이름은 반드시 입력하야 합니다");
				continue;
			}

			FileWriter fileWriter = null;
			PrintWriter out = null;

			try {
				fileWriter = new FileWriter(basePath + fileName);
				out = new PrintWriter(fileWriter);
				out.printf("%d:%d:%d\n", score.get맞은개수(), score.get틀린개수(), score.get포인트());
				out.flush();
				out.close();
				System.out.println("게임저장 완료!!!");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(fileName + "파일 생성 오류");
				System.out.println("파일 이름을 다시 입력하세요");
			}
		} // end while

	} // end saveScore()

	protected void loadGame() {

		while (true) {

			System.out.println("불러올 파일이름을 입력하세요");
			System.out.print(">> ");
			String fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("게임을 처음부터 시작합니다");
				score = new GameVO(3);
				return;
			}

			FileReader fileReader = null;
			BufferedReader buffer = null;
			try {
				fileReader = new FileReader(basePath + fileName);
				buffer = new BufferedReader(fileReader);
				String reader = buffer.readLine();
				String[] sc = reader.split(":");
				this.score = new GameVO();

				score.set맞은개수(Integer.valueOf(sc[Values.score.맞은개수]));
				score.set틀린개수(Integer.valueOf(sc[Values.score.틀린개수]));
				score.set포인트(Integer.valueOf(sc[Values.score.포인트]));
				buffer.close();
				return;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("파일이 없습니다");
				System.out.println("파일명을 다시 입력하세요");
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("파일을 읽을 수 없습니다");
				score = new GameVO();
				return;
			}
		} // end while

	}
	
	
	protected void loadWords(String wordFile) {
		// TODO word.txt 파일을 읽어 wordList 만들어 두기
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);
			while(true) {
				
				String reader = buffer.readLine();
				if(reader == null) break;
				String words[] = reader.split(":");
				WordVO wordVO = new WordVO();
				wordVO.setEnglish(words[Values.word.영어]);
				wordVO.setKorea(words[Values.word.한글]);
				wordList.add(wordVO);
			}
			
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
