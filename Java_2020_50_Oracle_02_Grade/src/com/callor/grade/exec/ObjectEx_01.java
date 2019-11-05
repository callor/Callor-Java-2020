package com.callor.grade.exec;

import java.util.List;

import com.callor.grade.service.ObjectService;
import com.callor.grade.service.ObjectServiceV1;

public class ObjectEx_01 {

	public static void main(String[] args) {

		ObjectService dual = new ObjectServiceV1();
		List<Object> result = dual.selectAll();
		
		for(Object obj : result) {
			
			System.out.print("String : " + obj.toString() + "\t") ;
			System.out.print("Integer.valueOf() : " + Integer.valueOf(obj.toString()) + "\t") ; // .toString());
			System.out.println("(int) : " + (int)obj) ; // .toString());
			
		}

	}

}
