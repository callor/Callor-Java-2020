package com.callor.files.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_03 {

	public static void main(String[] args) {

		String fileName = "src/com/callor/files/data2.txt";
		FileWriter fileWriter;
		
		try {
			
			fileWriter = new FileWriter(fileName);
			/*
			 * 만약 파일을 writer하기위해 open 상태에서
			 * 무한 반복(loop) 상태에 빠지게 되면
			 * 그 파일은 아무도(프로세스) 사용할수 없게 된다.
			 * 심지어는 운영체제 상태에서 삭제를 하려고 할때도
			 * 삭제가 되지 않을 수 있다.(운영체제 재부팅후 삭제 가능)
			 * 
			 * 읽기위해 open한 경우는 close()하지 않아도 일단
			 * 큰 문제를 일으키지 않지만
			 * 기록을 위해 open한 경우는 반드시 close()하자!!
			 * 1. 기록한 내용을 파일에 정확히 저장하기 위해서
			 * 2. open된 상태로 방치되어 문제를 일으키지 않도록 하기 위해서
			 */
			while(true) {fileWriter.write("A");} 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
