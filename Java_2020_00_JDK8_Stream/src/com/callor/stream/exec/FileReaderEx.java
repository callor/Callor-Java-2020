package com.callor.stream.exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderEx {

	public static void main(String[] args) {
		Path path = Paths.get("src/com/callor/stream/data.txt");
		Stream<String> stream = null;
		
		// Stream으로 파일 읽기
		try {
			stream = Files.lines(path, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stream.forEach(System.out::println);
		stream.close();
		System.out.println();

		
		// FileReader, BufferedReader 로 읽기
		File file = path.toFile();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		stream = bufferedReader.lines();
		stream.forEach(System.out::println);
		stream.close();

	}
	
}
