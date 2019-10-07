package com.callor.stream.exec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JDK7_FileCopy_01 {

	public static void main(String[] args) throws IOException {


		String imgSrcFile = "src/com/callor/stream/2019_97886-2080.jpg";
		String imgCopyFile = "src/com/callor/stream/2019_97886-2080-Copy.jpg";
		

		Path path = Paths.get(imgCopyFile);
		Files.deleteIfExists(path); // 파일이 있으면 삭제
		Files.copy(new File(imgSrcFile).toPath(), new File(imgCopyFile).toPath());
		
		System.out.println("OK");

		
	}

}
