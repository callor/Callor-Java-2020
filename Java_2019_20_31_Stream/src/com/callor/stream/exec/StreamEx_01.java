package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamEx_01 {

	public static void main(String[] args) {
		
		String imgFile = "src/com/callor/stream/2019_1.png";

		/*
		 * 파일을 byte 단위로 읽을수 있는 class
		 * text file, 그림파일, 영상파일, 음악파일등 모든파일을 읽을수 있다.
		 */
		// 1. Stream클래스를 객체 선언할때 일단 null값으로 초기화를 하라
		FileInputStream fs = null;
		try {
			
			//2. 실제 파일을 open하여 읽을 준비하고
			fs = new FileInputStream(imgFile);
			int input = 0;
			while(true) {
				
				//3. 1byte씩 읽어서 변수에 저장
				input = fs.read();
				if(input == -1) break ; // 파일을 모두 읽었으면 반복끝..
				
				// input 변수에 담긴 값을 16진수로 표현
				System.out.printf("%02X\n", input);
			
			}
			
			//4. 가급적 읽기 끝나면 파일을 닫자
			fs.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		System.out.println("Hello Korea!!!");
		
	}

}
