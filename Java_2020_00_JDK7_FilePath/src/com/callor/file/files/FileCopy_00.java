package com.callor.file.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopy_00 {

	public static void main(String[] args) throws IOException {

		String srcFile = "src/com/callor/file/2019_97886-2080.jpg";
		String targetFile = "src/com/callor/file/2019_97886-2080_1.jpg";

		Path from = Paths.get(srcFile);
		Path to = Paths.get(targetFile);

		FileChannel fileChannel_from = FileChannel.open(
				from, StandardOpenOption.READ);

		FileChannel fileChannel_to = FileChannel.open(
				to, StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE);

		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;

		while (true) {

			buffer.clear();
			byteCount = fileChannel_from.read(buffer);
			if (byteCount == -1)
				break;

			buffer.flip();
			fileChannel_to.write(buffer);

		}

		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("[[파일 복사 성공]]");

	}

}