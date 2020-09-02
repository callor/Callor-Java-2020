package com.callor.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinEx {

	public static void main(String[] args) {

		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
		ForkJoinPool pool = new ForkJoinPool();

		pool.invoke(myRecursiveAction);

	}

}
