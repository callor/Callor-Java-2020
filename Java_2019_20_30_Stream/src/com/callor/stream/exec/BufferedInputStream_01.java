package com.callor.stream.exec;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream_01 {

	public static void main(String[] args) {

		String imgFile = "src/com/callor/stream/2019_97886-2080.jpg";

		FileInputStream sw_stream = null;
		try {
			sw_stream = new FileInputStream(imgFile);
			byte receive[] = new byte[32];

			// 다른 파일 입출력문과 마찬가지로 스스로 파일에 접근 할수 없어 FileInputStream 을 사용해서 BufferedInputStream
			// 객체를 선언 / 생성
//			BufferedInputStream buffer = new BufferedInputStream(sw_stream, 1024);
			BufferedInputStream buffer = new BufferedInputStream(sw_stream);
			// 버퍼의 사이즈를 정의(임의로 "1024"만큼 대입)

			// 시작 ㅡ> 역시 사용법은 FileInputStream과 동일
			buffer.read(receive);
			for (int i = 0; i < receive.length; ++i) {
				 System.out.printf("%X ", receive[i]);
			}
			// 끝 ㅡ> "read()" 메소드로 파일을 읽어와 콘솔창에 뿌려줌

			buffer.close();
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
