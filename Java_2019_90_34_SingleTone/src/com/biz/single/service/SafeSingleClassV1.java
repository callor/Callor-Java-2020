package com.biz.single.service;

public class SafeSingleClassV1 {

	private static SafeSingleClassV1 myObject;
	
	private String name;
	private String nation;
	
	private SafeSingleClassV1() {
	}
	
	// getInstance() method에 synchronized 키워드를 추가 하므로써
	// 이 싱글톤 클래스는 thread safe 상태가 된다.
	// 게으른 초기화 코드다 라고 한다.
	// 상당히 코드 실행이 늦기 때문에
	public static synchronized SafeSingleClassV1 getInstance() {
		if(myObject == null )
			myObject = new SafeSingleClassV1();
		return myObject;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNation() {
		return this.nation;
	}
	
}
