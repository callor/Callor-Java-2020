package com.callor.app.filewriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * 
 * 한글 인코딩과 관련한 이슈를 해결하기 위하여는
 * OutputStreamWriter를 사용하여 인코딩을 지정해 주어야 한다
 * 
 * Excel에서 파일을 읽기 위해 csv로 내보낼때는 
 * 한글 인코딩을 MS949로 변환해 주어야 한다
 * 
 */
public class FileOutStream_01 {
	
	public static void main(String[] args) throws IOException {
		
		
		
		FileOutputStream fileOut = null;
		BufferedWriter buffer = null;
		
		PrintWriter out = null;

		fileOut = new FileOutputStream("src/com/callor/app/data.csv");
		buffer = new BufferedWriter(new OutputStreamWriter(fileOut,"MS949"));
		out = new PrintWriter(buffer);
		
		out.println("대한민국만세,우리나라만세");
		
		out.flush();
		out.close();
		System.out.println("완료");
		
		
	}
	

}
