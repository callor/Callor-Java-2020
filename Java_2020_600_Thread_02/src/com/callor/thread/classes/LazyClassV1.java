package com.callor.thread.classes;

/*
 * SingleTone중에서 가장 안전한 SingleTone
 * multi thread 환경에서 변수값의 동기화를 잘 이루어
 * 문제소지를 거의 없도록 유지할수 있다.
 */
public class LazyClassV1 {

	public int sum;
	
	private LazyClassV1() {
	}
	
	public static LazyClassV1 getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		private static final LazyClassV1 INSTANCE = new LazyClassV1();
	}
	
}
