package com.callor.files.service;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderServiceV1 {
	
	FileReader fileReader;
	
	// 만약 read() method가 실행되는 동안
	// Exception이 발생을 하면
	// read() method를 호출한 곳으로
	// Exception을 toss 하라
	public void read(String fileName) 
			throws IOException {

		fileReader = new FileReader(fileName);
		
		// 전체 파일을 읽기 위해서 while() 반복문을 사용
		while(true) {
			
			int intReadChar = fileReader.read();
			
			// FileReader.read() method는
			// 파일에서 문자를 읽어 오는 중에
			// 모든 내용을 다 읽고 파일의 끝에 도달하면
			// -1을 return 한다.
			// read() method의 return값을 비교하여
			// while() 반복문을 종료하자
			// if(intReadChar == -1) 로 사용해도 되지만.
			// if(intReaderChar < 0) 의 코드가 
			//		더 안전한 코드이다.
			if(intReadChar < 0) break;
			System.out.print((char)intReadChar);
		}
		// 파일을 읽고 난 후
		// OS에게 파일 정보를 모두 사용했다라고 알려주는 것이
		// resource(자원)를 절약하는 코딩이다.
		fileReader.close();

	}
}
