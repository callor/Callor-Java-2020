package com.biz.list.service;

import java.util.List;

public class ListEx_01 {

	public static void main(String[] args) {
		
		ListMakeServiceV1 lm = new ListMakeServiceV1();
		ListRecServiceV1 lr = new ListRecServiceV1();
		
		lm.makeStrList();
		List<String> strList = lm.getStrList();
		
		lr.setStrList(strList);
		lr.viewList();
		
	}

}
