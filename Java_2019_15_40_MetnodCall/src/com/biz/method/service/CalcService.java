package com.biz.method.service;

public class CalcService {

	public void addNum() {
		System.out.println("대한민국만세");
	}
	
	
	public void addNum(int num1) {
		System.out.println(num1 + 12345);
	}
	
	public int addNum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}

}
