package com.callor.stream.exec;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedEx_01 {

	public static void main(String[] args) {
		
		String imgFile = "src/com/callor/stream/2019_2.png";
		
		FileInputStream fs = null;
		BufferedInputStream buffer = null;
		
		/*
		 * BufferedInputStream
		 * FileInputStream으로 open된 파일을 읽어서 
		 * 		buffer 메모리에 임시 저장을 하고
		 * read() method를 통해서 buffer로 부터 값을 읽는다
		 */
		try {
			
			fs = new FileInputStream(imgFile);
			buffer = new BufferedInputStream(fs);

			byte[] bytes = new byte[32];
			buffer.read(bytes);
			
			for(int i = 0 ; i < bytes.length;i++) {
				System.out.printf("%02X ",bytes[i]);
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
