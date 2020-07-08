package com.callor.stream.exec;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx_01 {

	public static void main(String[] args) {
		
		InputStreamReader reader = new InputStreamReader(System.in);
		
		char[] buffer = new char[1024];
		try {
			System.out.print("문자열 입력 >> ");
			reader.read(buffer);
			System.out.println(buffer);
			String strReader = String.valueOf(buffer);
			System.out.println(strReader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
