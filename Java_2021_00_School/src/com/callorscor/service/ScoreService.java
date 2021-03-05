package com.callorscor.service;

import java.io.IOException;

public interface ScoreService {

	public void maikScore();
	public void saveScoreToFile() throws IOException ;
	public void saveScoreToFile(String fileName) throws IOException ;
	public void printAllScore() throws IOException ;
	public void printStudentScore() throws IOException ;
		
}
