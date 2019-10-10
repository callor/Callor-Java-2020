package com.biz.classes.service;

public class ClassServiceV1 {
	
	// 문자열 변수를 매개변수로 받은 method
	public void getName(String strName) {
		strName = "성춘향";
	}
	
	// 문자열 배열을 매개변수로 받는 method
	public void getName(String[] strNames) {
	
		strNames[0] = "장보고";
		strNames[1] = "임꺽정";

	}
	
}
