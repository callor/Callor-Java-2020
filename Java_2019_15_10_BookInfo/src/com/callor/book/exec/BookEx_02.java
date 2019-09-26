package com.callor.book.exec;

import com.callor.book.service.BookService;
import com.callor.book.service.BookServiceImpV1;

public class BookEx_02 {

public static void main(String[] args) {
		
		BookService bs = new BookServiceImpV1();

		// bs.input(); // 1개의 도서정보를 입력받아라
		
		// interface에 구현되지 않은
		// input(int count) method를 호출해서 사용하려면
		// bs 객체를 BookServiceImpV1 class로 형변환을 해야한다
		// 이 코드로 인해서 interface를 활용하는 의미가
		//	 	일부 퇴색된다.
		// 그래서
		// 만약 input(int count)처럼 처음에 interface를 만들때
		// 없던 method를 사용하려면
		// 가급적 설계자에게 요청하여
		// interface에 등록하도록 하는 것이 좋은 방법
		// ((BookServiceImpV1)bs).input(3);
		bs.input(3);
		bs.list();
		
		bs.view(2);

		
	}

}
