package com.callor.thread.exec;

import java.util.Scanner;

import com.callor.thread.classes.Run_01;
import com.callor.thread.classes.Run_02;

public class ThreadEx_02 {

	public static void main(String[] args) {

		Runnable r1 = new Run_01();
		Thread t1 = new Thread(r1);

		Runnable r2= new Run_02();
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String str = scanner.nextLine();
		
		
	}

}
