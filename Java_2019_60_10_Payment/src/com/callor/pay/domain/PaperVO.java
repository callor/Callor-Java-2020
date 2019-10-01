package com.callor.pay.domain;

public class PaperVO {

	private String paper;
	private int count;
	
	public PaperVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaperVO(String paper, int count) {
		super();
		this.paper = paper;
		this.count = count;
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
