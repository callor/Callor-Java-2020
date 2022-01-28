package com.callor.thread.exec.datas;

public class LazySingle {

	
	public String name;
	public int sum;
	
	private LazySingle() {
	}

	public static LazySingle getInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		private static final LazySingle INSTANCE = new LazySingle();
	}

}
