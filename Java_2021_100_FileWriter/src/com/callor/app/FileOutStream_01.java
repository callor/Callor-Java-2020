package com.callor.app;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileOutStream_01 {
	
	public static void main(String[] args) throws IOException {
		
		
		
		FileOutputStream fileOut = null;
		BufferedWriter buffer = null;
		
		PrintWriter out = null;

		fileOut = new FileOutputStream("src/com/callor/app/data.csv");
		buffer = new BufferedWriter(new OutputStreamWriter(fileOut,"MS949"));
		out = new PrintWriter(buffer);
		
		out.println("대한민국만세,우리나라만세");
		
		out.flush();
		out.close();
		System.out.println("완료");
		
		
	}
	

}
