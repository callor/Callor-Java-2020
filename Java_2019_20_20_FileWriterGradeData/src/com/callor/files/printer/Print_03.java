package com.callor.files.printer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print_03 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data4.txt";
		
		FileWriter fileWriter = null;
		PrintWriter fileOut = null;
		
		try {
			/*
			 * java 1.5 부터는
			 * PrintWriter 클래만 단독으로 사용해서
			 * 파일에 text를 기록할수 있다.
			 * 
			 * PrintWriter는 무조건 모든 파일을 새로 생성한다
			 * append mode로 파일을 open 할수 없다.
			 * 
			 * 만약 file을 append mode로 open 하고자 할때는
			 * 일단 FileWriter 를 사용해서 append mode로 open을 하고
			 * PrintWriter에(buffer 생략하고) 직접 주입한다.
			 */
			fileWriter = new FileWriter(fileName,true);
			fileOut = new PrintWriter(fileWriter);
			
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
