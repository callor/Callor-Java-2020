package com.callor.score;

import java.io.IOException;

import com.callor.score.service.ScoreService;
import com.callor.score.service.impl.ScoreServiceImplV1;

public class ScoerEx_01 {

	public static void main(String[] args) throws IOException {
		
		ScoreService sService = new ScoreServiceImplV1();
		sService.insertScore();
		
	}
	
}
