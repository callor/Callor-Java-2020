package com.callor.thread.exec.runnables;

public class RunThreadV1 implements Runnable{

	private String name = "";
	
	
	public RunThreadV1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		int sum = 0 ;
		for(int i = 0 ; i < 100 ; i++) {
			sum += i + 1;
		}
		System.out.printf("Hello Thread %s\n",name);
		System.out.printf("My name is %s  %d\n",name,sum);
	}

}
