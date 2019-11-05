package com.callor.thread.exec;

import com.callor.thread.classes.SingleClassV1;

public class SingleClassThreadEx_01 extends Thread{

	public void run() {
		
		SingleClassV1 sc = SingleClassV1.getInstance();
		sc.sum = 0;
		for(int i = 1 ; i <= 200 ; i++) {
			sc.sum += i;
		}
		System.out.println("Thread 에서 계산한 결과 : " + sc.sum );
		
	}
}
