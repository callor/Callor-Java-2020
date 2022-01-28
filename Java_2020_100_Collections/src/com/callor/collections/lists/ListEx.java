package com.callor.collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListEx {

	
	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		System.out.println(strList.toString());
		System.out.println(strList.hashCode());
		
		strList.add("대한민국");
		strList.add("우리나라");
		strList.add("Republic of Korea");
		System.out.println(strList.toString());
		System.out.println(strList.hashCode());

		strList = new Vector<String>();
		strList.add("대한민국");
		strList.add("우리나라");
		strList.add("Republic of Korea");

		System.out.println(strList.toString());
		System.out.println(strList.hashCode());
		
		strList = new LinkedList<String>();
		strList.add("대한민국");
		strList.add("우리나라");
		strList.add("Republic of Korea");

		System.out.println(strList.toString());
		System.out.println(strList.hashCode());
		
	}
	
}
