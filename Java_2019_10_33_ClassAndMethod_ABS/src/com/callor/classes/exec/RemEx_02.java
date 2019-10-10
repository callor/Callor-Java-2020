package com.callor.classes.exec;

import com.biz.classes.service.children.RadioClassV2;
import com.biz.classes.service.children.TvClassV2;
import com.biz.classes.service.parents.RemoconABSV2;

public class RemEx_02 {

	public static void main(String[] args) {

		// 자신으로 선언, 생성
		TvClassV2 tv1 = new TvClassV2();
		
		// 부모클래스로 선언, 자신의 생성자로 생성(초기화)
		// 인터페이스로 선언, 자신의 생성자로 생성 방식과 유사
		RemoconABSV2 tv = new TvClassV2();
		RemoconABSV2 radio = new RadioClassV2();
		
		tv.setName("TV");
		tv.power();
		tv.volUp();
		tv.volDown();
		tv.ChUp();
		tv.ChDown();

		radio.power();
		
	}

}
