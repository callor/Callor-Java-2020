package com.callor.enums;

public enum Status {
	
	대기,
	완료,
	실패;
		
	public static Status findByEnum(String eStr) {
		
		//  values() method는 enum의 상수들을 enum 타입의 배열로 리턴한다.
		for(Status status : values()) {

			//  name() method는 enum에서 정의하는 인스턴스 메소드로 호출된 enum의 이름을 리턴한다
			if(status.name().equals(eStr)) {
				return status;
			}
		}
		return null;
	}

}
