package com.biz.order.controller;

import com.biz.order.model.OrderVO;

public class ParamTest {

	public void add(int num1, int num2) {
		num1 = 100;
		num2 = 200;
		int sum = num1 + num2;
	}
	public void add(OrderVO orderVO) {
		orderVO.setO_pcode("알수 없음");
	}
	public void add(int[] intArray) {
		if(intArray.length > 0) {
			intArray[0] = 1000_000_000;
		}
	}
	
	public void add(String str) {
		str = "Republic of Korea";
	}
	
	public void add(Integer i) {
		i = 1000_000_000;
	}
	
	public OrderVO non(OrderVO orderVO) {
		orderVO = new OrderVO();
		orderVO.setO_pcode("나는 누구이게");
		return orderVO;
	}
	
	public int[] non(int[] intArray) {
		intArray = new int[3];
		intArray[0] = 3333_3333;
		return intArray;
	}
	
	
}
