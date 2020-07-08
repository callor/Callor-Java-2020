package com.callor.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PrintWriterEx_01 {

	public static void main(String[] args) {
		
		String printFile = "src/com/callor/print/print.txt";
		
		FileWriter fileWriter = null;
		PrintWriter output = null;
		Random rnd = new Random();
		
		System.out.println("PrintWriter");
		try {
			
			fileWriter = new FileWriter(printFile,true); // append mode
			output = new PrintWriter(fileWriter);
			
			output.println("====================================================================");
			output.println("PrintStream  실습");
			output.println("====================================================================");
			output.println("학번\t국어\t영어\t수학");
			output.println("--------------------------------------------------------------------");
			for(int i = 0 ; i < 10 ; i++) {
				output.printf("%05d\t",i+1);
				output.printf("%3d\t\t",rnd.nextInt(50) + 51);
				output.printf("%3d\t\t",rnd.nextInt(50) + 51);
				output.printf("%3d\n",rnd.nextInt(50) + 51);
			}
			output.println("====================================================================");
			output.flush();
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");
		
		
	}
	
	
}
	
