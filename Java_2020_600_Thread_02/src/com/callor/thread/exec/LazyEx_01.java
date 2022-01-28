package com.callor.thread.exec;

import com.callor.thread.classes.LazyClassV1;

public class LazyEx_01 {
	public static void main(String[] args) {
		
		LazyThreadEx_01 lt = new LazyThreadEx_01();
		lt.start();
		
		LazyClassV1 lc = LazyClassV1.getInstance();
		lc.sum = 0;
		for(int i = 0 ; i <= 100 ; i++) {
			lc.sum += i;
		}
		System.out.println(lc.sum);
		
	}
}
