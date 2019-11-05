package com.callor.thread.exec;

import com.callor.thread.classes.StaticClassV1;

public class StaticEx_01 {

	public static void main(String[] args) {

		StaticClassThread_01 sc = new StaticClassThread_01();
		sc.start();
		
		StaticClassV1.sum = 0;
		for(int i = 0 ; i <= 100; i++) {
			StaticClassV1.sum += i ;
		}
		System.out.println("main에서 계산한 합계");
		System.out.println(StaticClassV1.sum);
		
	}
}
