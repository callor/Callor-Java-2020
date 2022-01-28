package com.callor.thread.exec;

import com.callor.thread.classes.LazyClassV1;

public class LazyThreadEx_01 extends Thread{
	
	public void run() {
		LazyClassV1 lc = LazyClassV1.getInstance();
		lc.sum = 0;
		for(int i = 0 ; i <= 100 ; i++) {
			lc.sum += i;
		}
		System.out.println(lc.sum);
	}

}
