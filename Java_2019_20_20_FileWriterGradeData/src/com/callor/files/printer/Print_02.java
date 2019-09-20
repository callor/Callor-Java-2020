package com.callor.files.printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print_02 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data4.txt";
		
		PrintWriter fileOut = null;
		
		try {
			/*
			 * java 1.5 부터는
			 * PrintWriter 클래만 단독으로 사용해서
			 * 파일에 text를 기록할수 있다.
			 */
			fileOut = new PrintWriter(fileName);
			fileOut.println("우리나라만세");
			fileOut.println(30 * 40);
			fileOut.println(200 % 2);
			
			fileOut.printf("%5d\n",30+40);
			fileOut.print("Republic of Korea\n");
			
			fileOut.flush();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
