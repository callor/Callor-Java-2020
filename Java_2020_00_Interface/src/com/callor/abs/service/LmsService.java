package com.callor.abs.service;

import com.callor.abs.interfaces.ScoreService;

public class LmsService {

	private final ScoreService scoreService;
	
	public LmsService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public void scoreInput() {
		scoreService.input();
	}
	
}
