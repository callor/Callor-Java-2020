package com.biz.single.service;
/*
 * 현재 생성한 싱글클래스는
 * thread 환경에서 매우 불안전한 상태로 존재한다.
 * 이런 상태로 싱글클래스를 사용하게 되면
 * 프로젝트 전반에 많은 문제들을 일으킬수 있다.
 */
public class SingleClassV1 {

	/*
	 * 프로젝트가 시작될때
	 * 자신(SingleClassV1)을 myObject라는 인스턴트로
	 * 생성해 두어라
	 */
	private static SingleClassV1 myObject 
			= new SingleClassV1();
	
	/*
	 * 클래스 생성자를 private으로 선언하여
	 * new SingleClassV1() 생성자 코드를 사용할수 
	 * 		없도록 한다.
	 */
	private SingleClassV1() {
		// this.myObject 
	}
	
	public static SingleClassV1 getInstance() {
		return myObject;
	}
	
	
	
	
}
