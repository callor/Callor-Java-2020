package com.callor.std;

public interface InputService {

	Integer inputValue(String title);
	Integer inputValue(String title, int start);
	Integer inputValue(String title, int start, int end);
	
	String inputString(String title);
	String inputString(String title,boolean required);

}
