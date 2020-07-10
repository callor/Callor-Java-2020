package com.callor.grade.domain;

public class Score {

	private String num;
	private int kor;
	private int eng;
	private int math;
	private int music;
	
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	private int sum;
	private float avg;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "Score [num=" + num + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", music=" + music + ", sum="
				+ sum + ", avg=" + avg + "]";
	}


}
