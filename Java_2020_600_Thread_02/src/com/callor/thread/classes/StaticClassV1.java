package com.callor.thread.classes;

/*
 * 필드변수를 static으로 선언하여
 * 모든 클래스의 method에서 접근 가능하도록 하는 것
 * single thread에서도 변수값이 어떤이유로 변동되는 경도 많다.
 */
public class StaticClassV1 {

	// final : 이변수는 읽기만 해라!!
	public static final String name = "" ;
	public static int sum = 0 ;
	
}
