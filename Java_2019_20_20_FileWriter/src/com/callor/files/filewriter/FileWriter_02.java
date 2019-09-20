package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_02 {

	public static void main(String[] args) {

		FileWriter fileWriter;
		String fileName = "src/com/callor/files/data1.txt";
		
		try {
			fileWriter = new FileWriter(fileName);
			String str = String.format("%5d : %-5d\n",12,15);
			fileWriter.write(str);
			fileWriter.write("=================================================\n");
			fileWriter.write("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
			fileWriter.write("=================================================\n");
			fileWriter.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
