package com.callor.app.filewriter;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * 
 * System.out과 파일 출력을 같은 방법으로 사용하기
 * PrintStream을 사용하면 System.out과 동일한 방법으로 출력
 * System.out 대신 파일이름을 생성자에 매개변수로 전달하면 파일에 저장
 * 
 * 
 * PrintStream은 모든 자료형을 출력할수있는 print(), println()메서드가 오버로딩 되어있다.
 * 프로그램이 시작되면 장치와 연결된 
 * 출력 스트림인 System.out, System.err객체가 PrintStream객체이다.
 * 자바 5.0에서는 PrintStream의 format()메서드와 printf()메서드가 추가되어있기때문에 
 * 이전의 System.out.printf() 나 System.out.format()을 이용해서 출력문을 작성할수있었다.
 * 
 * PrintStream은 두가지 중요한 특징을 가진다.
 * 1. 다른 스트림과는 다르게 flush기능을 자동으로 처리할수있는 생성자를 가지고 있다.
 * 2. 모든 메서드의 예외 처리를 하지 않았다는 점
 * 
 * PrintStream의 주요생성자
 *  	생성자	설명
 *  	PrintStream(File file)	지정된 출력스트림을 기반으로 하는 PrintStream인스턴스를 생성한다.
 *  	PrintStream(File file, String csn)	
 *  	PrintStream(OutputStream out) 
 *  	PrintStream(OutputStream out, boolean autoFlush, String encoding)
 *  			autoFlush의 값을 true로 하면 println메서드가 호출되거나 개행문자가 
 *  			출력될때 자동으로 flush된다. 기본값은 false이다.
 *  	PrintStream(String fileName)
 *  	PrintStream(String fileName, String csn)
 */
public class PrintStream_02 {
	public static void main(String[] args) throws FileNotFoundException {
		
		String scoreFile = "src/com/callor/app/printStream.txt";
		
		printStream(System.out);
		printStream(new PrintStream(scoreFile));
		
	}

	// PrintStream을 사용하면 파일출력과 화면출력을 같은 method를 사용하여 처리할수 있다
	private static void printStream(PrintStream out) {
		out.println("System.out");
	}
	

}
