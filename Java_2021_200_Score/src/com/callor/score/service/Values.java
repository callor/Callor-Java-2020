package com.callor.score.service;

public class Values {

	public static void dLines(int nCount) {
		System.out.println("=".repeat(nCount));
	}
	public static void sLines(int nCount) {
		System.out.println("-".repeat(nCount));
	}

	public static void message(String message) {
		System.out.println("+".repeat(50));
		System.out.println(message);
		System.out.println("+".repeat(50));
	}
	
	
}
