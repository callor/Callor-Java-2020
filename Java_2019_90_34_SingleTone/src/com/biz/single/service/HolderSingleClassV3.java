package com.biz.single.service;
/*
 * thread 환경에서 안전성을 보장한다
 * = 동기화 보장
 * 
 * thread환경에서 개발자가 동기화 문제를 직접 해결하는 것은
 * 배보다 배꼽이 더 엄청나게 커지는 결과를 낳게된다.
 * 
 * 다양한 방법으로 thread safe 하기 위해 
 * 여러가지 도구를 사용을 한다.
 * 
 * 운영체제에게 관리를 맡기는 방법도 사용했지만
 * JVM 환경에서는 썩 좋은 패턴이 아니다.
 * = 운영체제마다 메모리를 관리하는 방법이 달라서
 * 		호환성에 문제를 일으킬수 있기 때문에
 * 
 * Holder 방식은 JVM의 초기화(시작) 과정에서 원자적특성을 이용하여
 * 싱글톤클래스의 초기화와 thread 관련된 문제에 대한 책임을
 * 전적으로 JVM에게 일임시킨다.
 * == 나는 관심없으니, JVM 네가 알아서 해 달라
 * 
 * 코드가 비교적 간단하고
 * 매우 안전적(안정적)이어서 최근에 가장 많이 사용하는 기법
 * 
 */
public class HolderSingleClassV3 {
	private HolderSingleClassV3() {
	}
	
	// Inner class
	// 클래스 내부에 존재하는 클래스
	private static class InnerHolder {
		public static final HolderSingleClassV3 INSTANCE
					= new HolderSingleClassV3();
	}
	public static HolderSingleClassV3 getInstance() {
		return InnerHolder.INSTANCE;
	}
	public void viewName() {
		System.out.println("나는 싱글톤이다!!!");
	}

}
