package com.callor.score;

import java.io.IOException;

import com.callor.score.service.StudentService;
import com.callor.score.service.impl.StudentServiceImplV1;

public class StudentEx_01 {
	
	public static void main(String[] args) throws IOException {
		
		StudentService stService = new StudentServiceImplV1();
		stService.printStudent();
		
	}

}
