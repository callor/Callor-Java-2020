package com.callor.thread.exec.runnables;

import com.callor.thread.exec.datas.SingleClassV1;
import com.callor.thread.exec.datas.StaticClassV1;

public class RunThreadV2 implements Runnable{

		
	public RunThreadV2(String name) {
		StaticClassV1.name = name;
	}
	
	@Override
	public void run() {
		
		// StaticClassV1.sum = 0;
		for(int i = 0 ; i < 100 ; i++) {
			StaticClassV1.sum += i + 1;
		}
		System.out.printf("Hello Thread %s\n",StaticClassV1.name);
		System.out.printf("My name is %s  %d\n",StaticClassV1.name,SingleClassV1.sum);
	}

}
