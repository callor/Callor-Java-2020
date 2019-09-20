package com.callor.files.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderBufferServiceV2 {
	
	FileReader fileReader;
	BufferedReader buffer;
	
	public void read(String fileName) throws IOException {
		
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);

		// buffer.readLine()은 파일에서 한줄(~~\n)을 읽는다
		// buffer.readLine()이 반복해서 실행될때마다
		// 계속해서 다음줄의 문자열을 읽어 들이도록 되어 있다.
		// 파일에 저장된 문장의 줄수 만큼 buffer.readLine()을
		// 반복해서 실행하면
		// 파일의 모든 내용을 읽을 수 있을 것이다.
		
		while(true) {
			String reader = buffer.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		// close() method는 resource를 반납하는 기능
		// close() 실행할때는
		// buffer를 먼저 close()하라
		buffer.close();
		fileReader.close();
	
	}
}
