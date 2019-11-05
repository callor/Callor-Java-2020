package com.callor.thread.exec.runnables;

import com.callor.thread.exec.datas.SingleClassV1;

public class RunThreadV3 implements Runnable{

	private String name = "";
	
	
	public RunThreadV3(String name) {
		SingleClassV1.setName(name);
	}
	
	@Override
	public void run() {
		
		SingleClassV1.sum = 0;
		for(int i = 0 ; i < 100 ; i++) {
			SingleClassV1.sum+= i + 1;
		}
		System.out.printf("Hello Thread %s\n",SingleClassV1.getName());
		System.out.printf("My name is %s  %d\n",SingleClassV1.getName(),SingleClassV1.sum);
	}

}
