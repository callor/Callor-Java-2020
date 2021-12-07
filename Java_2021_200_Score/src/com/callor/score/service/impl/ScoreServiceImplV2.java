package com.callor.score.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import com.callor.score.service.InputService;
import com.callor.score.service.ScoreService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 implements ScoreService {

	protected final int 국어 = 0;
	protected final int 영어 = 1;
	protected final int 수학 = 2;
	protected final int 과학 = 3;
	protected final int 국사 = 4;

	protected InputService inService;	
	
	protected List<Integer> kors;
	protected List<Integer> engs;
	protected List<Integer> math;
	
	public ScoreServiceImplV2() {
		kors= new ArrayList<Integer>();
		inService = new InputServiceImplV2();
		
		kors = new ArrayList<Integer>();
		engs = new ArrayList<Integer>();
		math = new ArrayList<Integer>();

	}
		
	@Override
	public void printScoreList() {
		for(int i = 0 ; i < kors.size() ; i++) {
			System.out.printf("%d\t",kors.get(i));
			System.out.printf("%d\t",engs.get(i));
			System.out.printf("%d\n",math.get(i));
		}
	}
	
	@Override
	public void inputScore() {
		Integer[] scores = new Integer[this.subList.length];
		for(int st = 0 ; st < 5 ; st++) {
			for(int sb = 0 ; sb < this.subList.length ; sb++) {
				scores[sb] = inService.inputValue(this.subList[sb], 0,100);
				if(scores[sb] == null) {
					System.out.println("종료");
					return ;
				}
			}
			kors.add(scores[0]);
			engs.add(scores[1]);
			math.add(scores[2]);
		}
	}
	


}
