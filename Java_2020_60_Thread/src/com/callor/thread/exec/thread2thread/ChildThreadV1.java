package com.callor.thread.exec.thread2thread;

public class ChildThreadV1 implements Runnable {

	int ID = 0;
	public ChildThreadV1(int ID) {

		this.ID = ID;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(ID);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
