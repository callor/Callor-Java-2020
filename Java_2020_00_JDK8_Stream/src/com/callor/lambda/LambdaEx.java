package com.callor.lambda;

public class LambdaEx {

	public static void main(String[] args) {
		
		// java 1.8 이전의 익명 클래스 선언
		SimpleInterface simpleImpV1 = new SimpleInterface() {
			
			@Override
			public void action() {
				System.out.println("익명 클래스");
			}
		};

		// java 1.8 람다식으로 선언한 익명 클래스
		// 인터페이스
		//                            method signature
		//								    method implementation
		SimpleInterface simpleImpV2 = () -> System.out.println("람다식의 시작");	
		simpleImpV1.action();;
		simpleImpV2.action();
		
		// 람다식 선언
		SimpleArgInterface simpleImpV3 = (int num1, int num2) -> num1 * num2 ;
		int times = simpleImpV3.action(50, 60);
		System.out.println(times);
		
		
		
	}
	
	
}
