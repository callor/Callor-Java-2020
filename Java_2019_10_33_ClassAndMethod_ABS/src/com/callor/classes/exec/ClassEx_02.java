package com.callor.classes.exec;

import com.biz.classes.service.ClassServiceV1;

public class ClassEx_02 {

	public static void main(String[] args) {
		/*
		 * 현재 클래스(ClassEx_02)가 아닌
		 * 다른 클래스(ClassServiceV1)에 있는 
		 * 		method를 호출하기
		 */
		
		// cs 객체 선언하기
		// 아직 cs 객체를 사용할 수 없는상태!!
		ClassServiceV1 cs; 
		
		// cs 객체 초기화, 생성
		// cs는 인스턴스가 되었다 라고 표현
		// cs 객체를 사용할수 있는 상태가 되었다.
		// ==> ClassServiceV1 클래스에 선언된 method를
		//		호출할 수 있다.
		cs = new ClassServiceV1();
		
		String strName = "홍길동";
		cs.getName(strName);
		System.out.println("strName:" + strName);
		
		String[] strNames = new String[2];
		strNames[0] = "이몽룡";
		strNames[1] = "성춘향";
		
		System.out.println("strNames[0] : " + strNames[0]);
		System.out.println("strNames[1] : " + strNames[1]);
		
		// getName(String[] strNames) method 호출하기
		cs.getName(strNames);
		System.out.println("strNames[0] : " + strNames[0]);
		System.out.println("strNames[1] : " + strNames[1]);
		
	}
}
