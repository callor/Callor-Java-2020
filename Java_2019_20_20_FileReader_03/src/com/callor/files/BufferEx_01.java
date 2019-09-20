package com.callor.files;

import java.io.IOException;

import com.callor.files.service.FileReaderBufferServiceV2;

public class BufferEx_01 {

	public static void main(String[] args) {

		FileReaderBufferServiceV2 fb = new FileReaderBufferServiceV2();
		String fileName = "src/com/callor/files/data.txt";
		try {
			fb.read(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
