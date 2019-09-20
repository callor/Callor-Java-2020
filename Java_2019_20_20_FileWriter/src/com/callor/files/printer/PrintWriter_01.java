package com.callor.files.printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriter_01 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/filewriter/print1.txt";
		
		PrintWriter printWriter ;
		
		try {
			printWriter = new PrintWriter(fileName);
			for(int i = 0 ; i < 10 ; i++) {
				printWriter.println(i);	
			}
			printWriter.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
