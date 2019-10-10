package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

import com.callor.stream.domain.BookVO;

public class ListEx_02 {

	public static void main(String[] args) {

		String objSaveFile = "src/com/callor/stream/bookList.dat";
		
		/*
		 * 인터페이스와 유사한 추상클래스로 선언
		 * null 값으로 초기화(clear)
		 */
		InputStream is = null;
		ObjectInput obj = null;
		
		try {
			/*
			 * 파일을 읽기 상태로 open
			 */
			is = new FileInputStream(objSaveFile);
			/*
			 * 파일에 저장된 변수를
			 * 실제 변수로 재생(환원)하기 위한
			 * 보조 Stream 연결
			 */
			obj = new ObjectInputStream(is);
			
			/*
			 * 실제 변수로 재생
			 * 저장된 변수type을 그대로 선언 해 주어야 한다.
			 * 
			 * 다수의 변수나 객체를 재생할때는
			 * 저장한 순서대로 재생해야 한다.
			 */
			List<BookVO> bookList = (List<BookVO>)obj.readObject();
			obj.close();
			
			for(BookVO vo : bookList) {
				System.out.print(vo.title + "\t");
				System.out.print(vo.comp+ "\t");
				System.out.print(vo.price+ "\n");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
