package com.callor.grade.service;

public interface ScoreService {

	public void loadScore();
	public void loadScore(String scoreFile);
	
	public boolean inputScore() ;
	public void scoreList() ;
	public void saveFile() ;
	
}
