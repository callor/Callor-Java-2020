package com.callor.grade.service;

import com.callor.grade.domain.Student;

public interface StudentService {

	public void loadStudent();
	public void loadStudent(String studentFile);
	public boolean inputStudent() ;
	public void studentList() ;
	public Student findByNum(String num);
	public void saveFile() ;
	
	
}
