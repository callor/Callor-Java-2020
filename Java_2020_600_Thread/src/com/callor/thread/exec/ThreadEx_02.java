package com.callor.thread.exec;

import com.callor.thread.exec.datas.StaticClassV1;
import com.callor.thread.exec.runnables.RunThreadV2;

public class ThreadEx_02 {

	public static void main(String[] args) {

		System.out.println(StaticClassV1.sum);
		
		Runnable run1 = new RunThreadV2("1st");
		Thread tr1 = new Thread(run1);

		Runnable run2 = new RunThreadV2("2nd");
		Thread tr2 = new Thread(run2);

		Runnable run3 = new RunThreadV2("3rd");
		Thread tr3 = new Thread(run3);

			
		tr1.start();
		tr2.start();
		tr3.start();

	}

}
