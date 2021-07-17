package com.callor.abs.service;


/*
 * abstract class
 * abs class는 interface와 성질이 매우 비슷하다
 * 미 완성된 abstract method를 가지고 있으며
 * 이 클래스를 상속받은 클래스는 abstract method를 반드시 구현해야만한다
 * 
 * interface는 모든 method가 abasctract method이다
 * 
 * 경우에 따라 매우 중요한 역할을 수행하거나
 * 필수적으로 수행해야할 코드를 가진 method가 있다면
 * interface를 사용하면 불편해 질수 있다
 * 
 * 이럴때 abstract 클래스를 사용하면 된다.
 */
public abstract class AbsParent {

	public int defaultExec(int num1, int num2) {
		int sum = 0;
		for(int i = num1 ; i < num2 + 1; i++) {
			sum += i;
		}
		return sum;
	}
	public abstract void absExec();

	
	
}
