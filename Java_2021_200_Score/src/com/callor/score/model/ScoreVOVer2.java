package com.callor.score.model;

public class ScoreVOVer2 {
	
	private String num;
	private String name;
	private String[] subject;
	private Integer[] scores;
	
	private Integer total;
	private float avg;
	
	public ScoreVOVer2(int length) {
		this.scores = new Integer[length];
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSubject() {
		return subject;
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	public Integer[] getScores() {
		return scores;
	}
	public void setScores(Integer[] scores) {
		this.scores = scores;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	

}
