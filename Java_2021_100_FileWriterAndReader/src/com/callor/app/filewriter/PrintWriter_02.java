package com.callor.app.filewriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


/*
 * PrintWriter는 java 1.1에 추가된 문자 스트림 출력 클래스이다
 * 
 * PrintWriter클래스는 다른 스트림과 다르게 
 * 	바이트출력스트림과 문자 출력 스트림을 가지고 객체를 생성할수있는 클래스이다.
 * 
 * 자동 플러쉬 기능을 가지고 있다.
 * PrintWriter클래스의 생성자에는 
 * 		FileNotFoundException예외를 발생하기 때문에 반드시 예외처리를 해야한다.
 * 
 * PrintWriter의 주요생성자.
 * 생성자		설명
 * PrintWriter(OutputStream out)	자동플러시 없이 OutputStream객체로 PrintWreter객체를 생성한다.
 * PrintWrter(OutputStream out, boolean autoFlush)	자동플러시를 할수있는 PrintWriter객체를 생성한다.
 * PrintWriter(Writer out)	자동 플러시 없이 Writer객체로 PrintWriter객체를 생성한다.
 * PrintWriter(Writer out, boolean autoFlush) 
 * 
 * 
 */
public class PrintWriter_02 {

	public static void main(String[] args) throws IOException {
		
		Random rnd = new Random();
		int num1 = rnd.nextInt(100);
		int num2 = rnd.nextInt(100);
		
		String fileName = "src/com/callor/app/data.txt";
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		// file append
		fileWriter = new FileWriter(fileName,true);
		out = new PrintWriter(fileWriter);
		
		out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		out.printf("%d x %d = %d\n", num1, num2, num1 * num2);
		out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
		
		out.flush();
		out.close();
		
		System.out.println("완료");
		
		
		
		
	}
	
	
}
