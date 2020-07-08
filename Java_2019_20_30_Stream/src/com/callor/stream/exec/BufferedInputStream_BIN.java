package com.callor.stream.exec;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class BufferedInputStream_BIN {

	public static void main(String[] args) {

		String imgFile = "src/com/callor/stream/2019_97886-2080.jpg";

		FileInputStream sw_stream = null;
		try {
			sw_stream = new FileInputStream(imgFile);
			byte receive[] = new byte[1024];

			// 다른 파일 입출력문과 마찬가지로 스스로 파일에 접근 할수 없어
			// FileInputStream 을 사용해서 BufferedInputStream
			// 객체를 선언 / 생성
//			BufferedInputStream buffer = new BufferedInputStream(sw_stream, 1024);
			BufferedInputStream buffer = new BufferedInputStream(sw_stream);
			// 버퍼의 사이즈를 정의(임의로 "1024"만큼 대입)

			// 32개짜리 0 문자열 생성
			

			// 시작 ㅡ> 역시 사용법은 FileInputStream과 동일
			while (true) {
				int ret = buffer.read(receive);
				if (ret == -1)
					break;


				for (int i = 0; i < receive.length; ++i) {
					
					// 이진수로 표현하기
					String deciFormat = "0000,0000"; // 표현할 format 4자리마다 일단 컴마
					String binString = Integer.toBinaryString(receive[i]);
					binString = binString.substring(binString.length() > 8 ? binString.length()-8 : 0, binString.length());

					DecimalFormat df = new DecimalFormat(deciFormat);
					String s2 = df.format(Integer.valueOf(binString)).replace(",","-"); // 컴마를 - 로 치환
					System.out.println(s2);
				}
				// 끝 ㅡ> "read()" 메소드로 파일을 읽어와 콘솔창에 뿌려줌
			}
			buffer.close();
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
