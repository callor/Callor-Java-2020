package com.callor.collections.stacks;

import java.util.Stack;

/*
 * 스택(Stack) 이란
 * 사전적 의미로는 '쌓다', '더미'라는 뜻이 있다.
 * 스택을 흔히 후입선출(선출후입), LIFO 라고 부르는데 
 * 쉽게 설명하자면 아래가 막힌 어떤 물체를 생각하면 된다.
 * 쓰레기통, 마트용 음료수 진열대 등 이러한 것이 스택 구조 이다.
 * 
 * 즉 한 쪽 끝에서만 자료(데이터)를 넣고 뺄 수 있는 형식의 자료 구조 이다.
 * 스택을 실제 개발환경에서 사용 하는 경우는 
 * 인터넷 브라우저의 '뒤로가기', '앞으로가기' 버튼을 생각하면된다.
 * 
 * 따라서 Stack은 데이터를 쌓는 형식으로 저장하는데 따라서 
 * 조회, 추가, 삭제 모두 가장 위에 있는 즉 가장 최근의 값에서 이루어 진다. 
 * 
 * 스택 구조에서 가장 상단에 있는 데이터를 Top이라고 한다.
 * 
 * 
 * Java의 스택(Stack) 클래스
 * 자바에서는 Stack 클래스를 지원하고있다.
 * 
 * Stack 클래스의 method는 다음과 같다
 * 
 * Stack<Element> stack = new Stack<>();
 * 과 같이 생성 할 수 있다.
 * 
 * Stack 클래스는 기본적으로
 * 
 * 
 * public Element push(Element item); // 데이터 추가
 * public Element pop(); // 최근에 추가된(Top) 데이터 삭제
 * public Element peek(); // 최근에 추가된(Top) 데이터 조회
 * public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
 * public int seach(Object o); // 인자값으로 받은 데이터의 위치 반환,
 */

public class StackEx_01 {
	
	public static void main(String[] args){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(3); //3
		stack.push(2); //3, 2
		
		System.out.println(stack.pop()); //2를 출력, 스택에는 3만 남음
		
		stack.push(6); //3, 6
		stack.push(8); //3, 6, 8
		
		System.out.println(stack.peek()); //가장 최근에 보관한 값은 8이며 값을 꺼내지는 않으므로 stack 내 값을 변화 없음 
		System.out.println(stack.search(6));//6이 저장된 위치(순번) 
		
		while(!stack.empty()){
			System.out.println(stack.pop());//8, 6, 3 순으로 꺼냄
		}
	}
	
}
