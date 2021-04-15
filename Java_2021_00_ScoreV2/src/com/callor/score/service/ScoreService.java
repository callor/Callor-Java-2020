package com.callor.score.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ScoreService {

	public void insertScore();
	public void loadScore() throws FileNotFoundException, IOException;
	public void printScore();

}
