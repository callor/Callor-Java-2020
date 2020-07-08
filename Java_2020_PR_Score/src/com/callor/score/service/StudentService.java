package com.callor.score.service;

import com.callor.score.domain.Student;

public interface StudentService {

	public void loadStudent(String studentFile);
	public Student findByNum(String num);
	
}
