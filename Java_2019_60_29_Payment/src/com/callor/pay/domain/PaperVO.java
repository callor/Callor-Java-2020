package com.callor.pay.domain;

public class PaperVO {
	
	private String member;
	private String paper; // 화폐의 액면가 이름 "50000"
	private int count; // 액면가에 대한 화폐의 매수
	
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "PaperVO [paper=" + paper + ", count=" + count + "]";
	}
	
	

}
