package com.callor.sec.exec;

import com.callor.sec.config.DBConnectionSEC;

public class IolistEx_01 {

	public static void main(String[] args) {

		// mybatis-config.xml, DBConn* 클래스, iolist-mapper.xml 테스트코드
		DBConnectionSEC.getInstance().openSession(true);
		System.out.println("Text OK!!!");
	
	}

}
