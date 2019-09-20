package com.callor.files.printer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileWriterPrintWriter_01 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/filewriter/data2.txt";
		
		FileWriter fileWriter;
		PrintWriter print;
		Random rnd ;
		
		try {
			
			rnd = new Random();
			fileWriter = new FileWriter(fileName,false);
			print = new PrintWriter(fileWriter);
			
			for(int i = 0 ; i < 10; i++) {
				String str = String.format("format : %20d",rnd.nextInt());
				print.println(str);
				print.printf("printf : %20d\n", rnd.nextInt());
			}
			
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
