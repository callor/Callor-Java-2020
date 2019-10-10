package com.callor.stream.exec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.callor.stream.domain.BookVO;

public class ListEx_01 {

	public static void main(String[] args) {

		String objSaveFile = "src/com/callor/stream/bookList.dat";
		
		List<BookVO> bookList = new ArrayList<BookVO>();	
		
		BookVO bookVO = new BookVO();
		bookVO.title = "Java만세";
		bookVO.comp = "영진출판사";
		bookVO.price = 5000;
		bookList.add(bookVO);

		bookVO = new BookVO();
		bookVO.title = "오라클";
		bookVO.comp = "생능출판사";
		bookVO.price = 30000;
		bookList.add(bookVO);

		bookVO = new BookVO();
		bookVO.title = "Do it 자바";
		bookVO.comp = "이지퍼블";
		bookVO.price = 25000;
		bookList.add(bookVO);
		
		/*
		 * 인터페이스와 유사한 추상클래스를 사용하여 선언
		 * 이때 각 객체는 null로 초기화(clear)를 해준다.
		 */
		OutputStream os = null;
		ObjectOutput obj = null;
		
		try {
			
			/*
			 * 파일을 기록하기 위한 상태로 open
			 */
			os = new FileOutputStream(objSaveFile);
			/*
			 * app 내에서 사용되는 변수,객체 값을 파일로
			 * 저장하기 위한 보조 Stream을 연결
			 */
			obj = new ObjectOutputStream(os);
			
			/*
			 * 자바의 내부 변수(bookList)를 파일로 기록
			 */
			obj.writeObject(bookList);
			obj.flush();
			obj.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		
	}

}
