package com.callor.thread.classes;

import java.util.Calendar;
import java.util.Date;

public class Cal_S_01 extends Thread{

	@Override
	public void run() {
		Calendar ca1 = Calendar.getInstance();
		ca1.set(2019, Calendar.OCTOBER, 10);
		Date date1 = ca1.getTime();

		for (int i = 0; i < 100; i++) {
			
			/*
			 * multi thread 환경에서 static 변수를 공유하여
			 * 코드를 작성할 경우
			 * 여러 thread에서 변수에 데이터를 기록(저장)할 경우
			 * 우선순위 등의 영향으로 경합을 벌이게 되고
			 * 데이터가 서로 겹치게 될수 있다.
			 * 
			 * 이럴때 공유할 변수를 synchronized 키워드로 감싸주면
			 * JVM에 의해 동기화가 이루어 진다.
			 */
			
			String curDate ;
			synchronized (SimStaticClass.sd) {
				curDate = SimStaticClass.sd.format(date1);	
			}
			System.out.println("Thread1 : " + curDate);
		
		}
	}
}
