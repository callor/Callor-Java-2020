package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx_03 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data2.txt";
		FileWriter fileWriter;
		
		try {
			/*
			 * FileWriter의 기본값은 항상 파일을 새로 만드는 것
			 * 만약 기존에 파일이 있으면 그 파일을 열어서
			 * 내용을 추가하고 싶을때는 
			 * 		생성자에 두번째 매개변수를 지정한다
			 * 		두번째 매개변수 기본값 false이고
			 * 		항상 파일을 새로 만드는 것
			 * 
			 * 		두번째 매개변수를 true로 지정하면
			 * 		파일이 없을때는 새로 만들고
			 * 		파일이 있으면 append mode로 파일을 open한다.
			 */
			fileWriter = new FileWriter(fileName,true);
			fileWriter.write("우리나라\n");
			fileWriter.write("대한민국\n");
			fileWriter.write("Republic of Korea\n");
			
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
