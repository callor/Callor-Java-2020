package com.callor.email;

import javax.mail.PasswordAuthentication;

public class MyAuth {
	
	
	String userName = null;
	String password = null;

	public MyAuth() {
	}

	public MyAuth(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	 PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}