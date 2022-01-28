package com.callor.file.paths;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Paths_03 {

	public static void main(String[] args) {
		
		Path path = Paths.get("src/com/callor/file","2019_97886-2080.jpg");
		File file = path.toFile();
		
		
		System.out.println("중첩경로 수 - " + path.getNameCount());
		
		System.out.println("파일의 절대경로        - " + file.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리 - " + file.getParent());
		
		
		
		
		
		

	}

}
