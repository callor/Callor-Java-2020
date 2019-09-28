package com.biz.word.service;

import java.util.List;
import java.util.Random;

import com.biz.word.domain.WordVO;

public class WordQuizServiceV1 implements WordQuizService {
	
	// protected
	// 상속받은 곳에서만 사용해라
	// 만약 이 클래스를 누군가에게 상속하고
	// 상속받은곳에서 wordVOList 를 사용할수 있게 하려면
	// protected를 설정하라
	protected List<WordVO> wordVOList ;
	
	public WordQuizServiceV1() {
	}
	
	public WordQuizServiceV1(List<WordVO> wordVOList) {
		this.wordVOList = wordVOList;
	}
	
	public void setWordVOList(List<WordVO> wordVOList) {
		this.wordVOList = wordVOList;
	}
	
	// wordVOList에서 임의 1개의 영문단어를 추출하여
	// console에 보여주시오
	public void viewEngWord() {
		
		Random rnd = new Random();
		int nSize = wordVOList.size();
		int index = rnd.nextInt(nSize);
		
		WordVO wordVO = wordVOList.get(index);
		System.out.println(wordVO.getEngWord());
		
	}

	@Override
	public void quizExec() {
		// TODO Auto-generated method stub
		
	}
}
