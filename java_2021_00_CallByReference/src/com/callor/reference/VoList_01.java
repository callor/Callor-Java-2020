package com.callor.reference;

import java.util.ArrayList;
import java.util.List;

public class VoList_01 {
	
	public static void main(String[] args) {
		
		List<ValueObject> voList = new ArrayList<ValueObject>();
		
		ValueObject vo = new ValueObject();
		
		vo.name = "홍길동";
		voList.add(vo);

		vo = new ValueObject();
		vo.name = "이몽룡";
		vo.str = "반갑습니다";
		voList.add(vo);
		
		System.out.print("원래의 List : ");
		System.out.println(voList.toString());
		
		updateList(voList);
		System.out.print("Update 후 List : ");
		System.out.println(voList.toString());
	
		addList(voList);
		System.out.print("add List 후 List : ");
		System.out.println(voList.toString());

		newList(voList);
		System.out.print("List new and add Update 후 List : ");
		System.out.println(voList.toString());

		
	}
	
	public static void updateList(List<ValueObject> voList) {
		voList.get(0).name = "성춘향";
		voList.get(1).str = "Viva Korea";
	}

	public static void addList(List<ValueObject> voList) {
		ValueObject vo = new ValueObject();
		vo.name = "장보고";
		voList.add(vo);
	}

	
	public static void newList(List<ValueObject> voList) {
		voList = new ArrayList<ValueObject>();
		
		try {
			voList.get(0).name = "성춘향";
			voList.get(1).str = "Viva Korea";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("List에 데이터를 추가할 수 없습니다");
			
		}
		
		ValueObject vo = new ValueObject();
		vo.name = "임꺽정";
		voList.add(vo);
		
	}
}
