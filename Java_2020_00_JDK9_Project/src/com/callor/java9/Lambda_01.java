package com.callor.java9;

public class Lambda_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Thread - Lambda Expression
		new Thread(()->{
			System.out.println("Hello World.");
		}).start();

	}

}
