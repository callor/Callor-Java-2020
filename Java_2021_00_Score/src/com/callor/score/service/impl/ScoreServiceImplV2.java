package com.callor.score.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.score.service.InputService;
import com.callor.score.service.ScoreService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 implements ScoreService {

	protected final int 국어 = 0;
	protected final int 영어 = 1;
	protected final int 수학 = 2;
	protected final int 과학 = 3;
	protected final int 국사 = 4;

	InputService inService;	
	
	protected List<Integer> kors;
		
	@Override
	public void printScoreList() {
		kors= new ArrayList<Integer>();
		inService = new InputServiceImplV2();
	}
	
	@Override
	public void inputScore() {
		Integer intKor = inService.inputValue(this.subList[0], 0,100);
		if(intKor != null) {
			kors.add(intKor);
		}
	}



}
