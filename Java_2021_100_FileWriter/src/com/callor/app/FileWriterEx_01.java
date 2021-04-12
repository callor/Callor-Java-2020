package com.callor.app;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileWriterEx_01 {

	public static void main(String[] args) throws IOException {
		
		Random rnd = new Random();
		int num1 = rnd.nextInt(100);
		int num2 = rnd.nextInt(100);
		
		String fileName = "src/com/callor/app/data.txt";
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		
		fileWriter = new FileWriter(fileName);
		out = new PrintWriter(fileWriter);
		
		out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		out.printf("%d x %d = %d\n", num1, num2, num1 * num2);
		out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
		
		out.flush();
		out.close();
		
		System.out.println("완료");
		
		
		
		
	}
	
	
}
