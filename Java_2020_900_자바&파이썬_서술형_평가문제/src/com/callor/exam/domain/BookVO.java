package com.callor.exam.domain;

public class BookVO {

	private String title;
	private String comp;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	@Override
	public String toString() {
		return "BookVO [title=" + title + ", comp=" + comp + "]\n";
	}
	
	
	
	
}
