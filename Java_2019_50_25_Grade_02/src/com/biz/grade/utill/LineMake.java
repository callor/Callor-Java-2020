package com.biz.grade.utill;

public class LineMake {
	public static String make(String str, int length) {
		String s = "";
		for(int i = 0 ; i < length; i++) {
			s += str;
		}
		return s;
	}
}
