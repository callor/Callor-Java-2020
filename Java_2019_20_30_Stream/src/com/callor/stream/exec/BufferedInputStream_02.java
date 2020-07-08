package com.callor.stream.exec;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream_02 {

	public static void main(String[] args) {
		
		String fileName = "src/com/callor/stream/2019_97886-2080.jpg";
		
		FileInputStream fileInput = null;
		BufferedInputStream bufferInput = null;
		
		
		try {
			fileInput = new FileInputStream(fileName);
			bufferInput = new BufferedInputStream(fileInput);
			
			while(true) {
				int r = bufferInput.read();
				if(r == -1) break;
				System.out.printf("%2X ",r);
			}
			bufferInput.close();
			fileInput.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
