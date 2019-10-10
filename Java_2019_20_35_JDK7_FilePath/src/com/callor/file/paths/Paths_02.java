package com.callor.file.paths;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Paths_02 {

	public static void main(String[] args) {

		
		/*
		 * 문자열 배열을 이용한 Paths 설정
		 * 연구 필요!!!
		 */
		
		String[] imgFile = {"/Users",
						"callor",
						"Documents",
						"workspace",
						"workspace_2020_java",
						"Java_2019_20_35_FilePath_JDK7",
						"src",
						"com",
						"callor",
						"file",
						"2019_97886-2080.jpg"
		};
		
		System.out.println("파일이름:_"+imgFile);
		File file = Paths.get(imgFile.toString()).toFile();
		
		
		String fileName = file.getName();
		int pos = fileName.lastIndexOf(".");
		
		
		System.out.println("경로를 제외한 파일이름 - " + file.getName());
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0,pos));
		System.out.println("확장자 - " + fileName.substring(pos+1));

		System.out.println("경로를 포함한 파일이름 - " + file.getPath());
		System.out.println("파일의 절대경로        - " + file.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리 - " + file.getParent());
		System.out.println();
		System.out.println("File.pathSeparator - " + File.pathSeparator); // 파일 전체 path 구분자. ;
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println("File.separator - " + File.separator); // 디렉터리 구분다. /
		System.out.println("File.separatorChar - " + File.separatorChar);
		System.out.println();
		System.out.println("user.dir="+System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));
		
		
		

	}

}
