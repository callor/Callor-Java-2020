package com.callor.file.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Files_03_Channel_Read_Write {

	public static void main(String[] args) throws IOException {

		// 파일을 읽고 쓸 수 있도록 하고 싶다면?
		FileChannel fileChannel = FileChannel.open(Paths.get("./file.txt"), 
				StandardOpenOption.READ,
				StandardOpenOption.WRITE);

		ByteBuffer byteBuffer = ByteBuffer.allocate(100);

		Charset charset = Charset.defaultCharset();
		String data = "";
		int byteCount;

		while (true) {
			byteCount = fileChannel.read(byteBuffer);
			if (byteCount == -1) {
				break;
			} else {
				byteBuffer.flip();
				data += charset.decode(byteBuffer).toString();
				byteBuffer.clear();
			}
		}
		System.out.println(data);

	}

}
