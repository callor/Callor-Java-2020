package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_05 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data5.txt";
		FileWriter fileWriter;
		
		try {
			
			// true 옵션 : 파일을 열어서 내용을 추가하라!!
			// append mode open 이라고 한다.
			fileWriter = new FileWriter(fileName,true);
			String str = String.format("%s\n","대한민국");
			fileWriter.write(str);
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
