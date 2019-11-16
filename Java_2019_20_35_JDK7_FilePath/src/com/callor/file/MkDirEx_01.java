package com.callor.file;

import java.io.File;

public class MkDirEx_01 {

	public static void main(String[] args) {

		
		File file = new File("c:/test/folder");
		
		/*
		 * 상위 디렉토리(/test) 가 없으면 /folder를 생성하지 못함
		 */
		boolean result = file.mkdir();
		
		System.out.println("mkdir()" + (result ? "디렉토리 생성" :"디렉토리 생성오류"));
		
		/*
		 * 상위 디렉토리(/test)를 생성하고 /folder 디렉토리를 생성
		 */
		result = file.mkdirs();
		System.out.println("mkdirs()" + (result ? "디렉토리 생성" :"디렉토리 생성오류"));
		
		
	}

}
