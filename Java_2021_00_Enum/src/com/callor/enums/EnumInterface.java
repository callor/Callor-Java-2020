package com.callor.enums;

public interface EnumInterface {
	default String message(String user) {
		return user +" 님 " + this.getMessage();
	}
	public String getMessage();
}
