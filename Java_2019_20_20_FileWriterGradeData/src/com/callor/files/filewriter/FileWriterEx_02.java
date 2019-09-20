package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx_02 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data1.txt";
		
		FileWriter fileWriter = null;
		
		try {

			// 항상 fileName의 파일을 생성하라
			// 만약 기존에 파일이 있으면 내용이 삭제된다.!!
			fileWriter = new FileWriter(fileName);
			fileWriter.write("Korea\n");
			fileWriter.write("대한민국\n");
			fileWriter.write("우리나라\n");
			fileWriter.write(String.format("%05d\n", 1)); // 00001
			fileWriter.write(String.format("합계 : %5d\n", 30+40)); // 
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
