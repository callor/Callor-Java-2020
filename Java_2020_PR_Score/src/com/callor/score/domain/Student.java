package com.callor.score.domain;

public class Student {

	private String num;
	private String name;
	private int gradeNum;
	private String dept;
	
	private String addr;

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gradeNum=" + gradeNum + ", dept=" + dept + ", addr=" + addr
				+ "]";
	}

	
	
	
	
}
