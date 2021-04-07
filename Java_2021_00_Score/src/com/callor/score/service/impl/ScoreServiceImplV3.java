package com.callor.score.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.score.model.ScoreVOVer2;
import com.callor.score.service.InputService;
import com.callor.score.service.ScoreService;

public class ScoreServiceImplV3 extends ScoreServiceImplV1 implements ScoreService {

	protected final String[] subject;
	
	protected final int 국어 = 0;
	protected final int 영어 = 1;
	protected final int 수학 = 2;
	protected final int 과학 = 3;
	protected final int 국사 = 4;

	protected InputService inService;
	protected List<ScoreVOVer2> scoreList;
	
	public ScoreServiceImplV3() {
		inService = new InputServiceImplV2();
		scoreList = new ArrayList<ScoreVOVer2>();
		subject = new String[] {"국어","영어","수학","과학","국사"};
	}
		
	@Override
	public void printScoreList() {
		System.out.println("=".repeat(50));
		for(String sbName : subject) {
			System.out.print(sbName + "\t");
		}
		System.out.println();
		System.out.println("-".repeat(50));
		
		for(int i = 0 ; i < scoreList.size() ; i++) {
			ScoreVOVer2 vo = scoreList.get(i);
			for(int sb = 0 ; sb < subject.length ; sb++) {
				System.out.printf("%d\t",vo.getScores()[sb]);
			}
			System.out.println();
		}
		System.out.println("=".repeat(50));
	}
	
	@Override
	public void inputScore() {

		for(int st = 0 ; st < 5 ; st++) {
			
			Integer[] scores = new Integer[subject.length];
			for(int sb = 0 ; sb < this.subList.length ; sb++) {
				Integer score = inService.inputValue(this.subList[sb], 0,100);
				if(score == null) {
					System.out.println("종료");
					return ;
				}
				scores[sb] = score;
			}
			ScoreVOVer2 scoreVO = new ScoreVOVer2(subject.length);
			scoreVO.setScores(scores);
			scoreList.add(scoreVO);
		}
	}
	
	
	


}
