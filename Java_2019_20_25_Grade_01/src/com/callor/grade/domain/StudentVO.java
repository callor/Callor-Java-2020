package com.callor.grade.domain;

public class StudentVO {

	private String strNum;
	private String strEngName;
	private String strKorName;
	
	public String getStrNum() {
		return strNum;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public String getStrEngName() {
		return strEngName;
	}
	public void setStrEngName(String strEngName) {
		this.strEngName = strEngName;
	}
	public String getStrKorName() {
		return strKorName;
	}
	public void setStrKorName(String strKorName) {
		this.strKorName = strKorName;
	}
	
	@Override
	public String toString() {
		return "StudentVO [strNum=" + strNum + ", strEngName=" + strEngName + ", strKorName=" + strKorName + "]";
	}
	
	
	
	
}
