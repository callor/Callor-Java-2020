package com.callor.score.model;


/*
 * 00126:		학번
 * 매재찬:		이름
 * 경제학:		학과
 * 2:			학년
 * 1:			반
 * 울산광역시 울주군 문수로382:	주소
 * 010-6239-1705	전화번호
 */
public class StudentVO {
	
	
	private String stNum;
	private String stName;
	private String stDept;
	private String stGrade;
	private String stClass;
	private String stAddr;
	private String stTel;
	
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentVO(String stNum, String stName, String stDept, String stGrade, String stClass, String stAddr,
			String stTel) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stDept = stDept;
		this.stGrade = stGrade;
		this.stClass = stClass;
		this.stAddr = stAddr;
		this.stTel = stTel;
	}

	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	public String getStGrade() {
		return stGrade;
	}
	public void setStGrade(String stGrade) {
		this.stGrade = stGrade;
	}
	public String getStClass() {
		return stClass;
	}
	public void setStClass(String stClass) {
		this.stClass = stClass;
	}
	public String getStAddr() {
		return stAddr;
	}
	public void setStAddr(String stAddr) {
		this.stAddr = stAddr;
	}
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}
	@Override
	public String toString() {
		return "StudentVO [stNum=" + stNum + ", stName=" + stName + ", stDept=" + stDept + ", stGrade=" + stGrade
				+ ", stClass=" + stClass + ", stAddr=" + stAddr + ", stTel=" + stTel + "]";
	}
	
	

}
