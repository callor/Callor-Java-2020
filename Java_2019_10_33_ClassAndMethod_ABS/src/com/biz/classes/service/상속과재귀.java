package com.biz.classes.service;

public class 상속과재귀 {
	public static void main(String[] args) {
		Parent obj = new Child();
		System.out.print(obj.compute(4));
	}
}

class Parent {
	int compute(int num) {
		System.out.println("Parent");
		if (num <= 1)
			return num;
		return compute(num - 1) + compute(num - 2);
	}
}

class Child extends Parent {
	
	int compute(int num) {
		System.out.println("Child");
		if (num <= 1)
			return num;
		return compute(num - 1) + compute(num - 3);
	}
}
