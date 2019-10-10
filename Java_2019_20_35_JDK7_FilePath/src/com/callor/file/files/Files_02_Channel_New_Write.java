package com.callor.file.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Files_02_Channel_New_Write {

	public static void main(String[] args) throws IOException {

		// "./file.txt" 파일을 생성 후 어떠한 내용을 쓰고 싶다면?
		FileChannel fileChannel = FileChannel.open(Paths.get("src/com/callor/file/file.txt"), 
						StandardOpenOption.CREATE_NEW,
						StandardOpenOption.WRITE);

		String data = "티스토리 블로그 알통몬";
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer byteBuffer = charset.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		
		System.out.println("file.txt : " + byteCount + " bytes written");
		fileChannel.close();


	}

}
