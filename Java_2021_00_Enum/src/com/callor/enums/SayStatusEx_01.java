package com.callor.enums;

public class SayStatusEx_01 {
	
	
	public static void main(String[] args) {
		
		System.out.println(SayStatus.대기.sayStatus("홍길동"));
		System.out.println(SayStatus.완료.sayStatus("홍길동"));
		System.out.println(SayStatus.실패.sayStatus("홍길동"));
		
	}

}
