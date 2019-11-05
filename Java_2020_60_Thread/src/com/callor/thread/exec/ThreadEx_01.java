package com.callor.thread.exec;

import com.callor.thread.exec.runnables.RunThreadV1;

public class ThreadEx_01 {

	public static void main(String[] args) {

		
		Runnable run1 = new RunThreadV1("1st");
		Thread tr1 = new Thread(run1);

		Runnable run2 = new RunThreadV1("2nd");
		Thread tr2 = new Thread(run2);

		Runnable run3 = new RunThreadV1("3rd");
		Thread tr3 = new Thread(run3);

			
		tr1.start();
		tr2.start();
		tr3.start();

	}

}
