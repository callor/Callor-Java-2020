package com.biz.word.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.biz.word.domain.WordVO;

public class WordQuizServiceV2 extends WordQuizServiceV1 {

	// wordVO를 현재클래스의 모든 method가 볼수 있다.
	// == 값을 읽을 수 있다 
	WordVO wordVO;
	public int nCount ;
	
	public WordQuizServiceV2() {
		
		nCount = 0;
		
	}
	
	// V1에서 선언된 wordVOList를 사용하기 위해서 제거
	// List<WordVO> wordVOList ;
	
	
	// V1에서 선언된 setWordVOList() 를 사용하기 위해서 제거
	// public void setWordVOList(List<WordVO> wordVOList) {
	// 	this.wordVOList = wordVOList;
	// }
	
	// wordVOList에서 임의 1개의 영문단어를 추출하여
	// 알파벳을 낱개로 분해한후
	// 무작위로 섞어서 console에 보이시오
	public void viewEngWord() {

		// 단어맞추기를 1번이라도 틀린적이 있으면
		// nCount가 0 보다 클것이고
		// 그러면 이미 생성되어 있는 wordVO를
		// private viewEngWord(wordVO)에게  보내서
		// 다시한번 뒤섞은 뒤 보여주기
		if(nCount > 0) {
			System.out.println();
			this.viewEngWord(wordVO);
			return ;
		}
		
		// 새로운 단어로 시작이 되는 경우
		//  	게임을 최초로 시작한 경우
		//  	앞에서 단어를 맞추었을 경우
		Random rnd = new Random();
		int nSize = wordVOList.size();
		int index = rnd.nextInt(nSize);
		
		wordVO = wordVOList.get(index);
		
		this.viewEngWord(wordVO);

	} // end viewEngWord()
	
	private void viewEngWord(WordVO wVO) {

		// 임시코드 실제 삭제될 코드
		// System.out.println(wVO.getEngWord());
		
		String word = wVO.getEngWord();
		
		String[] words = word.split(""); // 알파벳단위로 분해하기
		
		// 문자열 배열을 문자열형 List로 바꾸는 방법
		List<String> quizWords = Arrays.asList(words);
		
		// 뒤죽박죽 섞는 방법
		for(int i = 0 ; i < quizWords.size() ; i++) {
			Collections.shuffle(quizWords);	
		}
		System.out.println(quizWords);
		
		// ABS 순으로 정렬하는 방법
		Collections.sort(quizWords);
		System.out.println(quizWords);
	
	}

	/*
	 * viewEngWord() method에서 뒤섞어 보여준 단어의
	 * 원형을 키보드로 입력받고
	 * 맞는지 틀린지를 보여주는 코드
	 * 
	 * 예를들어
	 * [e, n, c, n, c, o, r]를 보여주고
	 * concern 이라는 단어를 입력하면 "맞았어요"
	 * 아니면 "틀렸어요"를 보여주기
	 * 
	 */
	public void quizExec() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------------");
		System.out.print("단어입력, 힌트(H), 종료(-0) >> ");
		String strEngWord = scan.nextLine();
		
		if(strEngWord.equals("-0")) {
			nCount = -1;
			return;
		}
		
		if(strEngWord.equals("H")) {
			System.out.println("-------------------------");
			System.out.println(wordVO.getKorMeans());
			
			int half = wordVO.getEngWord().length() / 2;
			System.out.println(wordVO.getEngWord().substring(0,half));
			System.out.println("-------------------------");
		
		}
		
		
		if(wordVO.getEngWord().equalsIgnoreCase(strEngWord)) {
			System.out.println("--------------------");
			System.out.println("맞았었요");
			System.out.println("시도횟수 : " + (nCount + 1));
			System.out.println("---------------------");
			System.out.println(wordVO.getKorMeans());
			System.out.println("---------------------");
			nCount = 0;
		} else {
			System.out.println("--------------------");
			System.out.println((nCount + 1) + " 번 틀렸어요");
			System.out.println("--------------------");
			/*
			System.out.print("계속(Enter), 힌트보기(H+Enter)>>");
			String strH = scan.nextLine();
			if(strH.equals("H")) {
				System.out.println("----------------------");
				System.out.println(wordVO.getKorMeans());
				System.out.println("----------------------");
			}
			*/
			nCount ++;
		}
	}
	
	
}
