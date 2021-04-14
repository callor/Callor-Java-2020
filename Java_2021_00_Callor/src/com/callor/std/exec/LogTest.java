package com.callor.std.exec;

import com.callor.std.impl.LOG;

public class LogTest {

	public static void main(String[] args) {
		final String className = Thread.currentThread().getStackTrace()[1].getClassName();
		LOG.log("반갑습니다",className);
		
		
		LOG.log("호랑나비");
		
		StackTraceElement[] ste = new Throwable().getStackTrace();
		for(StackTraceElement s : ste) {
			System.out.println(s.getClassName());
		}
		
	}
	
}
