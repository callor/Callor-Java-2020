package com.callor.line;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/*
 * Line 단위로 파일 읽기
 */
public class LineNumberReaderEx {

	public static void main(String[] args) {

		String fileName = "src/com/callor/line/data.txt";
		
		FileReader fileReader = null;
		LineNumberReader line = null;
		
		
		try {
			fileReader = new FileReader(fileName);

			// LineNumberReader는 BufferedReader를 상속받고 있다.
			// buffer = new BufferedReader(fileReader);
			line = new LineNumberReader(fileReader);
			String reader = new String();
			while(true) {
				
				
				reader = line.readLine();
				if(reader == null) break;
				System.out.printf("%d : %s\n",line.getLineNumber(),reader);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
