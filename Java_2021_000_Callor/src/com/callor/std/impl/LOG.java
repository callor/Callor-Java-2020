package com.callor.std.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LOG {

	public static void log(String msg, String fileName) {
		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter("C:/Temp/" + fileName , true);
			out = new PrintWriter(fileWriter);

			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");
			String today = sd.format(date);

			out.println("=".repeat(50));
			out.printf("Exception Date : %s\n", today);
			out.printf("Exception Message : %s\n", msg);
			out.printf("Exception Class : %s\n", fileName);
			out.println("=".repeat(50));
			out.flush();
			out.close();
			System.out.println(msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}

		
	}
	
	public static void log(String msg) {

		// 나를 호출한 클래스 이름을 찾기
		StackTraceElement[] ste = new Throwable().getStackTrace();
		String className = "LOG";
		if(ste.length > 3) {
			className = Thread.currentThread().getStackTrace()[2].getClassName();	
		}
		log(msg, className);
		
//		StackTraceElement[] ste = new Throwable().getStackTrace();
//		String fileName = ste[ste.length - 1].toString();
//		System.out.println(fileName);
//		log(msg, fileName);
//		
//		StackTraceElement[] st = Thread.currentThread().getStackTrace();
//		for(StackTraceElement s : st) {
//			System.out.println(s.getClassName());
//		}
		
		
	}

}
