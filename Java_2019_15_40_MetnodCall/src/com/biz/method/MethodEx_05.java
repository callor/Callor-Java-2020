package com.biz.method;

import java.util.List;

import com.biz.method.service.MakeListService;

public class MethodEx_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeListService ms = new MakeListService();
		
		List<Integer> intList = ms.getListAll(30);
		for(int i : intList) {
			System.out.println(i);
		}

	}

}
