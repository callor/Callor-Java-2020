package com.callor.enums;

public class EnumInterfaceEx {

	public static void main(String[] args) {
		
		/**
		 *  EnumInterfaceImpl.성공 을 사용하면
		 *  EnumInterfaceImpl 생성자를 호출하고
		 *  내부에 message 변수에 문자열을 세팅한다.
		 *  
		 *  message() method는 인터페이스에 선언된 default method를 호출하고
		 *  메시지를 생성한다.
		 */
		String result = EnumInterfaceImpl.성공.message("홍길동");
		System.out.println(result);
		
	}
	
}
