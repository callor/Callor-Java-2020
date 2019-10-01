package com.biz.list.exec;

import java.util.List;

import com.biz.list.service.ListMakeServiceV1;
import com.biz.list.service.ListRecServiceV2;

public class ListEx_02 {

	public static void main(String[] args) {

		ListMakeServiceV1 lm = new ListMakeServiceV1();
		lm.makeStrList(); // list 생성
		List<String> strList = lm.getStrList();
				
		ListRecServiceV2 홍길동 
				= new ListRecServiceV2(strList, "홍길동");
		
		ListRecServiceV2 이몽룡
				= new ListRecServiceV2(strList, "이몽룡");
		
		ListRecServiceV2 성춘향
				= new ListRecServiceV2(strList, "성춘향");

		홍길동.viewList();
		홍길동.remove();
		
		이몽룡.viewList();
		이몽룡.remove();
		
		성춘향.viewList();
		성춘향.remove();
		
		홍길동.viewList();
		홍길동.remove();
		
		홍길동.viewList();
		이몽룡.viewList();
		성춘향.viewList();
		
		
		
	
	}
}
