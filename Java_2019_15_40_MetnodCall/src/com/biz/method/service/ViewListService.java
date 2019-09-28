package com.biz.method.service;

import java.util.List;

public class ViewListService {
	
	public void setListAll() {
		System.out.println("나는 하는일이 하나도 없다네!!");
	}

	/*
	 * 정수값이 ??개 들어있는 list를 매개변수로 전달 받고
	 * 1. list를 콘솔에 보여주고
	 * 2. list에 포함된 정수값이 몇개인지를 return
	 */
	public int setListAllAndView(List<Integer> intList) {
		
		int nSize = intList.size();
		for(int i : intList) {
			System.out.println(i);
		}
		return nSize;
		
	
	}
}
