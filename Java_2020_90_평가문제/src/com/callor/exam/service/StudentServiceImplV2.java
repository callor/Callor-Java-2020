package com.callor.exam.service;

import com.callor.exam.domain.BookVO;

public class StudentServiceImplV2 extends StudentServiceImpl {

	@Override
	public void inputStudent() {
		
		List<BookVO> bookList = new ArrayList<BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setTitle("자바만세");
		bookVO.setComp("우리출판사");
		
		bookList.add(bookVO);
		
	}

	
	
}
