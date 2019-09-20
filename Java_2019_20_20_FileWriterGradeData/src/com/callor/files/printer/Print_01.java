package com.callor.files.printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print_01 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data3.txt";
		
		FileWriter fileWriter = null;
		BufferedWriter buffer = null;
		
		/*
		 * System.out.print*() 의 console 출력 method와
		 * 같은 형식으로 파일에 text를 기록하기 위해서
		 * PrintWriter 클래스를 활용한다.
		 */
		PrintWriter out = null;
		
		try {

			fileWriter = new FileWriter(fileName);
			buffer = new BufferedWriter(fileWriter);
			out = new PrintWriter(buffer);
			
			out.println("대한민국만세");
			out.printf("%5d", 100);
			out.print("우리나라만세\n");
			
			out.flush();
			out.println("대한민국만세");
			out.printf("%5d", 100);
			out.print("우리나라만세\n");
			
			out.close();
			buffer.close();
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
