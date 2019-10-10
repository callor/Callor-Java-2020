package com.callor.stream.exec;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream_01 {

	public static void main(String[] args) {

		FileOutputStream sw_stream = null;
		try {
			sw_stream = new FileOutputStream("src/com/biz/stream/booklist.dat");
			byte receive[] = { 'C', 'H', 'O', 'I' };

			// 스스로 파일에 접근을 할수 없기때문에 FileOutputStream 사용하여 BufferedOutputStream 객체를 선언 / 생성
			// 여기서 특이한 점은 임시로 저장할 버퍼의 크기를 마음대로 조절이 가능하다는 점이다
			BufferedOutputStream b_out_stream = new BufferedOutputStream(sw_stream, 1024);
			// "1024" 크기로 제 마음대로 버퍼의 크기를 잡아주었다
			// 즉, 파일에 데이터를 쓰기 위해서는 1024가 모여야 보조기억장치에 접근하여 쓰게 된다

			b_out_stream.write(receive);
			// "write()" 메소드는 FileOutputStream과 동일

			b_out_stream.close(); // 이 부분은 이제 필수 부분인걸 알것이다
			sw_stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("OK");

	}

}
