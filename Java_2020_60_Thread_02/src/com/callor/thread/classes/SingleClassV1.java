package com.callor.thread.classes;

/*
 * 일반적인 SingleTone 클래스
 * single thread 환경에서는 메모리 절약을 수행하는 목적에 맞다.
 * 하지만 multi thread 환경에서는 동기화 문제를 일이키고
 * 
 * 때로는 SingleTone 이 아닌 다수의 객체인스턴스가 생성될수 있다.
 * ==> 동기화를 억지로 수행할 경우
 */
public class SingleClassV1 {

	private static SingleClassV1 singleClassV1;
	public int sum;
	
	static {
		
		// 강제로 동기화를 수행할경우 다수의 인스턴스가 생성되는 것을
		// 방지하는 코드
		if(singleClassV1 == null) {
			singleClassV1 = new SingleClassV1();	
		}
		
	}
	public static SingleClassV1 getInstance() {
		return singleClassV1;
	}

}
