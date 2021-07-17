package com.callor.abs;

import java.util.function.BinaryOperator;
import java.util.function.IntFunction;

import com.callor.abs.service.LambdaService;

public class LambdaMainEx_01 {

	public static void main(String[] args) {

		// interface를 이용한 익명 함수 선언
		LambdaService lf = new LambdaService() {
			@Override
			public int lamdaExec(int num1, int num2) {
				// TODO Auto-generated method stub
				return num1 * num2;
			}
		};
		int result = lf.lamdaExec(30,40);
		System.out.println(result);
		
		// interface를 이용한 익명 함수를 lambda로 선언
		LambdaService f1 = (num1, num2)->num1 + num2;
		System.out.println(f1.lamdaExec(100,200));
		
		LambdaService f2 = (num1, num2)-> num1 * 100 + num2;
		System.out.println(f2.lamdaExec(100, 100));
		
		
	}

}
