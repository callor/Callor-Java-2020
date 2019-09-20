package com.callor.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * data.txt 파일을 읽어서 기억장치로 가져 오려고 한다.
 * 1. 운영체제에게 data.txt을 읽을테니 허락을 해달라 라고 요청
 */
public class FileEx_01 {

	public static void main(String[] args) {

		String file = "src/com/callor/files/data.txt";
		/*
		 * FileReader
		 * 운영체제에게 파일을 읽을테니 허락해달라 하는 요청과
		 * 운영체제가 허락을 하면, 읽을 파일에 대한 정보를
		 * java 코드에서 사용할수 있도록 준비해 해 주는 클래스
		 * 읽고자 하는 파일이름을 파일이 저장된 폴더 path(경로)까지
		 * 문자열 형태로 전달하면서 객체로 생성해주면된다.
		 */
		
		FileReader fileReader = null; 
		
		try {
			/*
			 * FileReader 클래스를 사용해서 파일을 읽을 준비를 수행하는데
			 * 알수 없는 여러가지 이유로 파일을 읽는데 문제가 발생을 할수 있다
			 * 이때
			 * 만약 파일이 어떤이유로 지워졌거나 깨졌을 경우
			 * FileNotFouncExceipion이 발생할 확율이 있다.
			 * 
			 * 그래서 파일을 읽기 위한 객체 생성(초기화)명령문은
			 * 반드시 try catch 문으로 감싸도록 되어 있다.
			 * 
			 * 또한 FileReader의 선언문과
			 * 생성문을 분리를 하는데
			 * 그 이유는 fileReader 객체에 접근할 수 있는
			 * scope 문제를 해결하기 위한 것이다.
			 */
			fileReader = new FileReader(file);

			int alpha = fileReader.read();
			System.out.println(alpha);
			System.out.println((char)alpha);
			
			alpha = fileReader.read();
			System.out.println(alpha);
			System.out.println((char)alpha);

			alpha = fileReader.read();
			System.out.println(alpha);
			System.out.println((char)alpha);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
