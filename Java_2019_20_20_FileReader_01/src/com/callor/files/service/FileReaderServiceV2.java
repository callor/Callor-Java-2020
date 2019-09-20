package com.callor.files.service;

import java.io.FileReader;
import java.io.IOException;
/*
 * FileReader 클래스
 * 
 * text 파일을 직접 읽어서 문자단위로
 * CPU로 전송하여 연산을 수행할때 사용
 * 
 * 파일을 direct로 읽어서 처리를 하기 때문에
 * 파일이 매우 크면
 * App 실행 속도가 현저하게 느려진다.
 * 
 */
public class FileReaderServiceV2 {
	
	FileReader fileReader = null;
	
	/*
	 * 만약 read(String fileName) method가 실행되는 동안
	 * exception 발생을 하면
	 * read() method를 호출한 곳으로 exception을 toss 하라
	 */
	public void read(String fileName) throws IOException {
		
		fileReader = new FileReader(fileName);
		while(true) {
			int al = fileReader.read();

			if(al < 0) break;
			System.out.print((char)al);

		}
	}

}
