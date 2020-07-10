package com.callor.grade.service;

import com.callor.grade.domain.Score;

public interface ScoreService {

	public void loadScore();
	public void loadScore(String scoreFile);
		
	public boolean inputScore() ;
	
	public void calcSum();
	public void calcAvg();
	
	public void saveScoreVO(Score score);
	
	public void scoreList() ;
	public void saveFile() ;
	
}
