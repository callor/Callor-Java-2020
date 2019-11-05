package com.callor.thread.exec;

import com.callor.thread.exec.thread2thread.ParentThreadV1;

public class MultiThreadEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentThreadV1 pt = new ParentThreadV1();
		Thread thread = new Thread(pt);
		
		thread.start();

	}

}
