package com.callor.exam.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.exam.domain.BookVO;

public class Ex_07 {

	public static void main(String[] args) {
		
		List<BookVO> bookList = new ArrayList<BookVO>();
		bookList = new ArrayList<BookVO>();
		
		for(int i = 0 ; i < 10 ; i++) {
			
			BookVO bookVO = new BookVO();
			
			bookVO.setTitle("Do Ti 자바");
			bookVO.setComp("이지스퍼블리시");
			
			bookList.add(bookVO);
			
		}
	}
}
