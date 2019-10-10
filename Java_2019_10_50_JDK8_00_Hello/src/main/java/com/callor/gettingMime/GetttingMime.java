package com.callor.gettingMime;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Java 7 파일 및 URLConnection 클래스를 사용하여 
 * Java에서 파일의 MIME 유형을 얻는 방법을 보여줍니다.
 */
public class GetttingMime {

	public static void main(String[] args) {

		String fileName = "src/main/java/com/callor/gettingMime/GetttingMime.java";
		fileName = "src/main/java/com/callor/files/하트-퀸.png" ;
//		fileName = "src/main/java/com/callor/files/하트-킹.jpg" ;
		File file = new File(fileName);
		Path path = file.toPath();

		// using java 7 probeContentType
		String mimeType;
		URLConnection connection;
		try {
			mimeType = Files.probeContentType(path);
			
			// deprecate
			// connection = file.toURL().openConnection();
			// >> ↓
			URI url = file.toURI();
			connection = url.toURL().openConnection();
			
			System.out.println("connection : " + connection.getContentType());

			// guessContentTypeFromName
			System.out.println("ConTentType : " + URLConnection.guessContentTypeFromName(file.getName()));

			// getFileNameMap
			System.out.println("FileName : " + URLConnection.getFileNameMap().getContentTypeFor(file.getName()));
			System.out.println("mineType : " + mimeType);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
