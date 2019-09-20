package com.callor.java9;

public class Lambda_02 {

	static Func add = (int a, int b) -> a + b;
	Func sub = (int a, int b) -> a - b;
	static Func add2 = (int a, int b) -> { return a + b; };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = add.calc(1,2) + add2.calc(3, 4); // 10
		System.out.println(result);
	}

}
