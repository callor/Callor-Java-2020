package com.callor.files;

import java.io.IOException;

import com.callor.files.service.FileReaderBufferServiceV3;

public class BufferEx_02 {

	public static void main(String[] args) {

		FileReaderBufferServiceV3 fb = new FileReaderBufferServiceV3();
		String fileName = "src/com/callor/files/data.txt";
		try {
			fb.read(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
