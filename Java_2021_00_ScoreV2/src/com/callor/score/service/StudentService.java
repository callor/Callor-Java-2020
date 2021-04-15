package com.callor.score.service;

import java.io.IOException;

import com.callor.score.model.StudentVO;

public interface StudentService {
	
	public void insertStudent();
	public void loadStudent() throws IOException;
	public StudentVO getStudent(String num);
	public void printStudent();

}
