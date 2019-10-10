package com.callor.excel;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ExcelSaveEx_02 {

	public static void main(String[] args) throws IOException {

		String excelFile = "src/com/callor/excel/data.csv";
		
		OutputStream fileWriter;
		OutputStreamWriter os ; 
		BufferedWriter buffer;
		Random rnd = new Random();

		System.out.println(excelFile + "  Save !!");
		
		fileWriter = new FileOutputStream(excelFile);
		os = new OutputStreamWriter(fileWriter, "MS949");
		buffer = new BufferedWriter(os);
		
		for(int i = 0 ; i < 20 ; i++) {
			buffer.write(i+1 + ",");
			buffer.write("'" + rnd.nextInt(100000) + ",");
			buffer.write("대한민국만세,");
			buffer.write("우리나라만세,");
			buffer.write("Republic Of Korea,");
			buffer.newLine();
			buffer.flush();
		}
		
		buffer.write("SUM" + ",");
		buffer.write("=SUM(B1..B20),");
		buffer.write("Korea" + ",");
		buffer.newLine();
		buffer.flush();

		
		buffer.close();
		System.out.println("Write OK!!!");
		
	}

}
