package com.biz.word.exec;

import java.util.List;

import com.biz.word.domain.WordVO;
import com.biz.word.service.WordListMakeService;

public class WordEx_01 {

	public static void main(String[] args) {

		WordListMakeService wm = new WordListMakeService();
		
		String wordFileName = "src/com/biz/word/필수어휘.txt";
		
		try {
			
			wm.makeWordList(wordFileName); // list 생성
			List<String> wordStrList = wm.getWordStrList();
			List<WordVO> wordVOList = wm.getWordVOList();
			
			for(WordVO vo : wordVOList) {
				System.out.print(vo.getEngWord() + "\t");
				System.out.println(vo.getKorMeans());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
