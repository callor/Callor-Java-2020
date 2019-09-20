package com.callor.files.printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BufferedPrintWriter_01 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/filewriter/data2.txt";
		
		FileWriter fileWriter;
		BufferedWriter buffer;
		PrintWriter print;
		Random rnd ;
		
		try {
			
			rnd = new Random();
			fileWriter = new FileWriter(fileName,false);
			buffer = new BufferedWriter(fileWriter);
			print = new PrintWriter(buffer);
			
			for(int i = 0 ; i < 10; i++) {
				String str = String.format("format : %20d",rnd.nextInt());
				print.println(str);
				print.printf("printf : %20d\n", rnd.nextInt());
			}
			
			// 현재 buffer에 저장되어 있는 내용을 파일에 
			// 강제로 기록하라
			// close() 차이는 close() 실행하면
			// 더이상 write() 실행할수 없지만,
			// flush()는 실행한 후에  writer()를 다시 실행해도 된다.
			buffer.flush();
			buffer.write("12345");
			
			// 더이상 파일에 기록을 하지 않겠다!! 선언
			buffer.close();
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
