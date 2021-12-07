package com.callor.enums;

public enum SayStatus {

	대기 {
		String sayStatus(String user) {
			return String.format("%s 님 대기중", user);
		}
	},
	완료 {
		String sayStatus(String user) {
			return String.format("%s 님 접속 완료", user);
		}
	},
	실패 {
		String sayStatus(String user) {
			return String.format("%s 님 접속 실패", user);
		}
	};

	// enum 추상 method
	// Status.대기.sayStatus("홍길동") 처럼 사용가능
	abstract String sayStatus(String user);
	
}
