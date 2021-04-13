package com.callor.app;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * 
 * System.out과 파일 출력을 같은 방법으로 사용하기
 * PrintStream을 사용하면 System.out과 동일한 방법으로 출력
 * System.out 대신 파일이름을 생성자에 매개변수로 전달하면 파일에 저장
 * 
 */
public class PrintStream_01 {
	public static void main(String[] args) throws FileNotFoundException {
		
		String scoreFile = "src/com/callor/app/printStream.txt";
		
//		PrintStream out = new PrintStream(scoreFile);
//		out.println("printWriter");
		
//		out = System.out;
//		out.println("System.out");
//		out.close();	
		
		printStream(System.out);
		printStream(new PrintStream(scoreFile));
		
	}
	
	private static void printStream(PrintStream out) {
		out.println("System.out");
	}
	

}
