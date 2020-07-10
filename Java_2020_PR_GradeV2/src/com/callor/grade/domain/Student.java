package com.callor.grade.domain;

public class Student {

	private String num;
	private String name;
	private int gradeNum;
	private String dept;
	
	private String tel;

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

	public int getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gradeNum=" + gradeNum + ", dept=" + dept + ", tel=" + tel
				+ "]";
	}

	
	
	
	
}
