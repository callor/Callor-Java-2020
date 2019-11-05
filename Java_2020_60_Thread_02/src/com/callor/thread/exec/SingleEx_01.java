package com.callor.thread.exec;

import com.callor.thread.classes.SingleClassV1;

public class SingleEx_01 {

	public static void main(String[] args) {

		SingleClassThreadEx_01 st = new SingleClassThreadEx_01();
		st.start();
		
		SingleClassV1 sc = SingleClassV1.getInstance();
		sc.sum = 0;
		for(int i = 1 ; i <= 100 ; i++) {
			sc.sum += i;
		}
		System.out.println("main 에서 계산한 결과 : " + sc.sum );
		
	}

}
