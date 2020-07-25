package com.callor.exam.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.exam.domain.BookVO;

public class MainEx_02 {

	public static void main(String[] args) {
		
		List<BookVO> bookList = new ArrayList<BookVO>();
		for(int i = 0 ; i < 10 ; i++) {
			BookVO bookVO = new BookVO();
			bookList.add(bookVO);
		}
	}
	
	
}
