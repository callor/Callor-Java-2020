package com.callor.thread.exec.thread2thread;

/*
 * Threa에서 다른 Thread를 다수 실행하기
 * 
 * 
 */
public class ParentThreadV1 implements Runnable{

	@Override
	public void run() {

		 for(int i = 0 ; i < 5 ; i++) {
				// int intId = (int)(Math.random() * 100);
			    // 
			    ChildThreadV1  child = new ChildThreadV1(i);
			    // ust.start();
			    Thread thread = new Thread(child);
			    thread.start();
			}
		
	}

}
