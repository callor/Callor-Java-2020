package com.callor.print;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Random;

public class PrintStreamEx_01 {

	public static void main(String[] args) {
		
		String printFile = "src/com/callor/print/print.txt";
		
		PrintStream output = null;
		Random rnd = new Random();
		
		try {
			
			// PrintStream = System.out
			// output = System.out;
			output = new PrintStream(printFile);
			
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
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
	
