package com.callor.enums;


// interface를 상속받아 enum 만들기
public enum EnumInterfaceImpl implements EnumInterface {
	
	// enum 생성자를 호출하여 메시지를 보관한다
	성공("접속 성공"),
	실패("접속 실패");
	
	private String message ;
	private EnumInterfaceImpl(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
