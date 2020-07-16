package com.callor.system;

import java.io.InputStream;
import java.io.OutputStream;

public class SystemEx_01 {
	
	
	public static void main(String[] args) {
		
		/*
		 * System.out 클래스는 대표적인 static 클래스이다
		 * 별도로 인스턴스를 만들지 않아도 사용할 수 있다.
		 * 
		 */
		System.out.println("대한민국만세");
		
		/*
		 * System.out 클래스는 원래 OutputStream 클래스이다.
		 */
		OutputStream outputStream = System.out;
		
		
		InputStream inputStream = System.in;
		
		
		
	}

}
