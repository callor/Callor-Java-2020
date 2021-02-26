package com.callor.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListEx_01 {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		strList = new LinkedList<String>();
		strList = new Vector<String>();
		System.out.println(strList.toString());
		System.out.println(strList.hashCode());
		
		
	}

}
