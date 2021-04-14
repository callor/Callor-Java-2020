package com.callor.files.printer;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStream_01 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		String scoreFile = "src/com/callor/files/subject_score.txt";
		PrintStream out = new PrintStream(scoreFile);
		out.println("printWriter");
		
		out = System.out;
		out.println("System.out");
		out.close();
		
	}

}
