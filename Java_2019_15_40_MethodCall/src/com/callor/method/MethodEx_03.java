package com.biz.method;

import com.biz.method.service.CalcService;

public class MethodEx_03 {

	public static void main(String[] args) {

		// main에서 할 일들을
		// CalcService 클래스의 addNum() method를 사용해서
		// 대신 처리하고자 하는 것
		CalcService cs = new CalcService();
		for(int i = 0 ; i < 10 ; i++) {
			
			// CalcService클래스에 정의된 
			// addNum() method가 무슨일을 하는지 모르겠지만
			// 아무튼 10번 수행하라
			cs.addNum();
			
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			// CalcService 클래스에 정의된
			// addNum() method가 무슨일을 하는지 모르겠지만
			// 23이라는 정수를 보내주고(주입하고)
			// 아무튼 5번 수행하라
			cs.addNum(23);
		}
		
		// addNum() method가 무슨일을 하는지 모르겠지만
		// 32와 55 두개의 정수를 주입하고
		// 아무튼 1번만 수행하라
		// 실행결과는 ? : 보여주는 것이 아무것도 없다
		cs.addNum(32,55);
		
		// addNum() method가 무슨일을 하는지 구체적으로는 모르겠지만
		// 32와 54 두개의 정수를 주입하고
		// 뭔가 연산을 수행한 다음에
		// 그 결과를 내가 가지고 있는 result라는 변수에 담아달라
		int result = cs.addNum(32,54);
		// 그러면 이제 result라는 변수 값을 확인해 보면
		// addNum() method가 무슨일을 하는지 
		//	어느정도 짐작은 할수 있게 되었다.
		System.out.println(result);
		
	}
}
