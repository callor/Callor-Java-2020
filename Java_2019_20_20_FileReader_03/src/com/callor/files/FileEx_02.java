package com.callor.files;

import java.io.IOException;

import com.callor.files.service.FileReaderServiceV1;

public class FileEx_02 {

	public static void main(String[] args) {

		FileReaderServiceV1 fr = new FileReaderServiceV1();
		String fileName = "src/com/callor/files/data.txt";
		
		try {
			fr.read(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
