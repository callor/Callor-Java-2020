package com.callor.dbms.exec;

import com.callor.dbms.service.BBsServiceV4;

public class BbsMapEx_04 {

	public static void main(String[] args) {

		BBsServiceV4 bbs = new BBsServiceV4();
		System.out.println("========================================");
		System.out.println("MyBatis Select 결과를 Map에 담아오기");
		System.out.println("----------------------------------------");
		bbs.bbsMapTest();
		System.out.println("========================================");
	}

}
