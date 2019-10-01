package com.biz.list.service;

import java.util.ArrayList;
import java.util.List;

/*
 * ReciveService
 */
public class ListRecServiceV2 {
	
	/*
	 * recStrList는 외부에서 주입될 List
	 *   - ListRecServiceV2로 생성한 객체들이 모두 공유하는 List
	 *   - 다른 객체에서 recStrList 값을(개수를)변경하면
	 *   - 모든 객체(인스턴스)가 가지고 있는 recStrList 값이 같이 변동
	 *   
	 * myStrList 자체에서 new ArrayList() 생성할 List
	 * 	- ListRecServiceV2로 객체를 생성하면서
	 * 		new ArrayList() 로 생성을 하기 때문에
	 * 	- 각자 객체(인스턴스)에서 자신의 myStrList를 변경을 해도
	 *  - 다른 객체(인스턴스)에는 아무런 영향이 없다.
	 */
	private List<String> recStrList;
	private List<String> myStrList;
	private String name;
	
	/*
	 * myStrList : ListServiceV1에서 임의로 생성한 List
	 * recStrList : 외부에서 주입되는 List
	 */
	public ListRecServiceV2(List<String> recStrList, String name) {
		myStrList = new ArrayList<String>();
		this.recStrList = recStrList;
		this.name = name;
	}
	
	public void remove() {
		
		// myStrList에 recStrList의 0번째 요소를 복사하고
		// 각 플레이어가 받게되는 카드
		this.myStrList.add(this.recStrList.get(0));
		
		// recStrListdml 0번째 요소를 삭제
		// 블랙잭에서 Desk의 객체
		this.recStrList.remove(0);
		
	}
	
	public void viewList() {
	
		System.out.println("===========================");
		System.out.println(this.name);
		System.out.println("---------------------------");
		System.out.println(recStrList.toString());
		System.out.println(myStrList.toString());
		
		/*
		for(String str : this.recStrList) {
			System.out.println(str);
		}
		*/
	
	}
	

	
	

}
