package com.callor.abs.service.impl;

import com.callor.abs.service.AbsParent;

/*
 * AbsParent를 상속받은 클래스는
 * absExec() method 를 반드시 구현해야 하며
 * AbsParent 클래스에 구현된 
 * defaultExec() method는 그대로 사용할 수 있다
 */
public class AbsServiceExtendsV1 extends AbsParent{

	@Override
	public void absExec() {
		// TODO Auto-generated method stub
		
		int num1 = 1;
		int num2 = 100;
		int result = this.defaultExec(num1, num2);
		System.out.printf("%d ~ %d까지 덧셈결과 : %d",num1,num2,result);
		
	}

}
