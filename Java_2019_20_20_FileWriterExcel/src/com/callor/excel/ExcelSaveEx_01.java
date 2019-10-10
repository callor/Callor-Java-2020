package com.callor.excel;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Random;

public class ExcelSaveEx_01 {

	public static void main(String[] args) throws IOException {

		String excelFile = "src/com/callor/excel/data.csv";
		
		FileWriter fileWriter;
		OutputStreamWriter os ; 
		BufferedWriter buffer;
		Random rnd = new Random();

		System.out.println(excelFile + "  Save !!");
		
		// fileWriter = new FileWriter(excelFile);
		
		fileWriter = new FileWriter(excelFile);
		buffer = new BufferedWriter(fileWriter);
		
		for(int i = 0 ; i < 20 ; i++) {
			
			/*
			 * BOM (봄; Byte Order Mark)은 '바이트 순서 표시'입니다.
			 * 유니코드가, little-endian 인지 big-endian 인지 아니면 UTF-8 인지 쉽게 알 수 있도록, 
			 * 유니코드 파일이 시작되는 첫부분에 보이지 않게, 
			 * 2~3바이트의 문자열을 추가하는데 이것을 BOM이라고 합니다. 
			 * 텍스트 에디터 화면에서는 보이지 않고, 헥사 에디터(Hex Editor)*로 열었을 때만 보입니다.
			 * 
			 * little-endian 의 BOM : FF FE
			 * big-endian 의 BOM: FE FF
			 * UTF-8 의 BOM : EF BB BF
			 */
			
			// 한글 인코딩을 해결하기 위해 BOM(Byte Order Mask)을 Big-edian
			buffer.write("\uFEFF");
			
			buffer.write(i+1 + ",");
			buffer.write("'" + rnd.nextInt() + ",");
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
