package com.callor.stream.exec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryRead {
	public static void main(String[] args) {
		Path path = Paths.get("/Users/callor/Documents/개발자 문서");
		Stream<Path> stream = null;
		try {
			stream = Files.list(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stream.forEach(p -> System.out.println(p.getFileName()));

	}

}
