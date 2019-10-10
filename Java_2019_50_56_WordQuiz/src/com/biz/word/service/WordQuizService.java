package com.biz.word.service;

import java.util.List;
import java.util.Random;

import com.biz.word.domain.WordVO;

public interface WordQuizService {
	
	public void setWordVOList(List<WordVO> wordVOList) ;
	public void viewEngWord() ;
	
	public void quizExec() ;

}
