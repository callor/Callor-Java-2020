package com.callor.grade.utill;

public class Score {

	/*
	 * 1과목의 점수를 생성하는 메서드
	 */
	public static int makeScore() {
		int intScore = (int)(Math.random() * (100-50+1)) + 50;
		return intScore;
	}
	
	
}
