package com.callor.score.model;

public class StudentVO {

	private String num;
	private String name;
	private String grade; // 학년
	private String dept; // 학과
	private String address;
	
	
	
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", grade=" + grade + ", dept=" + dept + ", address="
				+ address + "]";
	}
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentVO(String num, String name, String grade, String dept, String address) {
		super();
		this.num = num;
		this.name = name;
		this.grade = grade;
		this.dept = dept;
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
	public String getDept() {
		return dept;
	}
	public String getAddress() {
		return address;
	}
	
	

}