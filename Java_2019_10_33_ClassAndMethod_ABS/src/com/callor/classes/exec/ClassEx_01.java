package com.callor.classes.exec;

public class ClassEx_01 {

	// main() method가 있는 클래스의 맴버변수(필드)영역에
	// 변수를 선언
	// stiatc 으로 설정된 method에서
	// 필드변수에 접근을 하려면
	// 필드변수도 static으로 선언을 해야 한다.
	static String strName = "홍길동";
	
	// main()는 static method이며
	// 프로젝트가 시작하면(Run) JVM이 제일먼저 찾아서
	// 실행하는 method
	// 진입점 method
	public static void main(String[] args) {
		strName = "이몽룡";
		getName(strName);
		System.out.println(strName);
	}
	/*
	 * main() method에서 getName() method를 호출하면서
	 * strName 변수를 파라메터로 전달하였다.
	 * 이때 strName 변수 이름등과는 아무런 상관 없이
	 * strName 변수에 담긴 값만 getName() method에 전달된다.
	 * 
	 * 전달된 파라메터(값)은
	 * getName() 메서드의 매개변수에 담겨서 
	 * method 내부로 복사된다.
	 * getName() 메서드 내부에서 strName 변수의 값을 변경해도
	 * main() method에서 참조하는 strName 변수의 값은
	 * 아무런 변동이 없다.
	 * ==> Call By Value
	 */
	
	// static으로 선언된 method에서
	// 다른 method를 호출하려면
	// 호출되는 method도 모두 static으로 선언되어야 한다.
	public static void getName(String strName) {
		// String strName 변수를 만들고 대기중...
		strName = "성춘향";
	}

}
