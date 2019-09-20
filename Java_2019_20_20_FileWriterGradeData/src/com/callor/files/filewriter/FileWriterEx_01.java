package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx_01 {

	public static void main(String[] args) {
	
		String fileName = "src/com/callor/files/data1.txt";
		/*
		 * FileWriter 클래스(class)를 사용해서
		 * fileWriter 객체(object = 변수와 같은 개념)를 선언
		 */
		FileWriter fileWriter = null;
		
		try {
			/*
			 * fileWriter객체를 FileWriter() 생성자 
			 * method를 이용해서
			 * 초기화 한다.
			 * fileWriter는 FileWriter 
			 * 		클래스의 
			 * 		instance(FileWriter의 복제본) 가 된다.
			 * 
			 * FileWriter() 생성자는 파일의 경로와 이름을
			 * 	매개변수로 받아서
			 *  파일을 새로 작성한다.
			 *  그리고 새로 작성된 파일에 대한 정보를
			 *  fileWriter 객체에 저장해 둔다.
			 *  
			 * FileWriter 클래스에 선어되어 있을
			 * 	여러 method 들을 사용해서
			 *  파일 기록과 관련된 기능을 수행할 수 있다.
			 * 
			 */
			fileWriter = new FileWriter(fileName);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
