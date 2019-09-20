package com.callor.files;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.callor.files.service.FileReaderServiceV1;

public class FileEx_03 {

	public static void main(String[] args) {

		FileReaderServiceV1 fs = new FileReaderServiceV1();
		
		try {
			fs.read("src/com/callor/files/data.txt");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
