package com.biz.single.service;

/*
 * thread에 안전하고 초기화과정을 좀더 빠르게
 * 개선한 싱글톤 코드
 */
public class SafeLazySingleV2 {
	
	// volotile : 휘발성있는
	// 잘 관리하지 않으면 날아간다..
	// java에서는 이 변수를 JVM 영역에 저장하지 않고
	// 	  컴퓨터 하드웨어적인 Main memory 영역에 저장해서
	// 	  운영체제가 관리하도록 하라
	// 멀티 thread에서 성능 향상을 위해서
	// 		운영체제 단계에서 메모리를 관리 하겠다 라는 의미
	private volatile static SafeLazySingleV2 instance;
	private SafeLazySingleV2() {
	}
	
	public static SafeLazySingleV2 getInstance() {
		
		if(instance == null) {
			synchronized (SafeLazySingleV2.class) {
				instance = new SafeLazySingleV2();	
			}
		}
		return instance;
		
	}
	

}
