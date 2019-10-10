package com.biz.classes.service.parents;
/*
 * abstract 클래스 : 추상클래스
 * 클래스는 클래스인데 미완성된 모양만 클래스다
 * 
 * 주요용도
 * 부모클래스로서 역할을 수행하는 클래스
 * = 부모클래스 : 주요기능(method)를 미리 만들어두고
 * 		상속받은곳에서 method의 기능을 사용하도록 하는 것
 * 		변수들도 선언해 두고 상속받은곳에서 
 * 			사용가능하도록 하는 것
 * 
 * 인터페이스의 역할도 수행하는 클래스
 * = 아직 주요기능을 구현하지는 않았지만
 * 		꼭 필요하니 구현하라는 설계도 역할
 * 
 * 추상클래스
 * : 일반클래스이며 인터페이인 클래스
 * 
 */
public abstract class RemoconABS {
	
	protected String name;
	public RemoconABS() {
		this.name = "나는 리모콘입니다";
	}

	public void power() {
		System.out.println(name);
	}
	
	public void volUp() {
		System.out.println("볼륨 올리기");
	};
	
	public abstract void volDown() ;
	
	public abstract void ChUp() ;
	public abstract void ChDown() ;

}
