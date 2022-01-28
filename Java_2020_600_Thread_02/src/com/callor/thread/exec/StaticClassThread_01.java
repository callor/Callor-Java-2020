package com.callor.thread.exec;

import com.callor.thread.classes.StaticClassV1;

public class StaticClassThread_01 extends Thread {

	@Override
	public void run() {
		
		StaticClassV1.sum = 0 ;
		for(int i = 1 ; i < 200 ; i++) {
			StaticClassV1.sum += i;
		}
		System.out.println("Thread에서 계산한 합계");
		System.out.println(StaticClassV1.sum);
	}
	
}
