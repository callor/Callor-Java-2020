package com.callor.thread.exec;

import com.callor.thread.classes.Cal_01;
import com.callor.thread.classes.Cal_02;

public class CalendarEx_01 {
	
	public static void main(String[] args) {
		
		Cal_01 ca1 = new Cal_01();
		ca1.start();

		Cal_02 ca2 = new Cal_02();
		ca2.start();

		
	}

}
