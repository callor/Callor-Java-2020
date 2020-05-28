package com.callor.files;

public class UserVO {

	private String 예명;
	private String 본명;
	
	
	
	public String get예명() {
		return 예명;
	}



	public void set예명(String 예명) {
		this.예명 = 예명;
	}



	public String get본명() {
		return 본명;
	}



	public void set본명(String 본명) {
		this.본명 = 본명;
	}



	@Override
	public String toString() {
		return "UserVO [예명=" + 예명 + ", 본명=" + 본명 + "]\n";
	}

	
	

}
