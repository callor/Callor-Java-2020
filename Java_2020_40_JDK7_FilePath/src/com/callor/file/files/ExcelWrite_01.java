package com.callor.file.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExcelWrite_01 {

	
	static String fileName = "src/com/callor/file/excel.csv";
	
	public static void main(String[] args) {

		// 출력 스트림 생성
		BufferedWriter bufWriter = null;
		Random rnd = new Random();

		try {
			
			/*
			 * excel 파일에서 읽을때 한글 깨지는 것을 방지하기 위해 한글 encoding을 MS949로 설정해야 한다.
			 * 이 파일을 excel에서 읽으면 정상이나
			 * 
			 * java에서 읽으려면 MalformedInputException이 발생한다.
			 * OS 마다 조금씩 다르다 
			 * 
			 */
			// bufWriter = Files.newBufferedWriter(Paths.get(fileName), Charset.forName("MS949"));

			// 이럴때는 인코딩을 UTF로 설정하고 한글 BOM을 파일에 기록해 주어야 한다.
			bufWriter = Files.newBufferedWriter(Paths.get(fileName), Charset.forName("UTF-8"));
			
			//
			// 한글 깨짐 방지 BOM 출력
			bufWriter.write("\uFEFF");

			
			for (int i = 0 ; i < 20 ; i++) {
				
				bufWriter.write(i+1 + ",");
				bufWriter.write("'" + rnd.nextInt() + ",");
				bufWriter.write("대한민국만세,");
				bufWriter.write("우리나라만세,");
				bufWriter.write("Republic Of Korea");
				bufWriter.newLine();
				bufWriter.flush();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufWriter != null) {
					bufWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Excel Write OK!!!");

	}


}
