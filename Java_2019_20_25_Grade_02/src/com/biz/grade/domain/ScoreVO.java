package com.biz.grade.domain;
/*
 * 학번, String, num
 * 국어, int, korScore
 * 영어, int, engScore
 * 수학, int, mathScore
 * 
 * 총점, int, sumScore
 * 평균, float, average
 * 석차, int, rank
 */
public class ScoreVO {
	private String num;
	private int korScore;
	private int engScore;
	private int mathScore;
	
	private int sumScore;
	private float average;
	private int rank;
	
	public ScoreVO(String num, 
				int korScore, 
				int engScore, 
				int mathScore) {
		super();
		this.num = num;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public ScoreVO(String num, int korScore, int engScore, int mathScore, int sumScore, float average, int rank) {
		super();
		this.num = num;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.sumScore = sumScore;
		this.average = average;
		this.rank = rank;
	}
	
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getSumScore() {
		return sumScore;
	}
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "ScoreVO [num=" + num + ", korScore=" + korScore + ", engScore=" + engScore + ", mathScore=" + mathScore
				+ ", sumScore=" + sumScore + ", average=" + average + ", rank=" + rank + "]";
	}
	
	
	
	
	
}
