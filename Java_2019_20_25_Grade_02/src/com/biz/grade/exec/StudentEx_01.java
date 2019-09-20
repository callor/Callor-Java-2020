package com.biz.grade.exec;

import com.biz.grade.service.StudentServiceV1;

public class StudentEx_01 {

	public static void main(String[] args) {

		StudentServiceV1 ss = new StudentServiceV1();
		String stdFileName = "src/com/biz/grade/학생명부.txt";
		
		try {
			ss.read(stdFileName);
			ss.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
