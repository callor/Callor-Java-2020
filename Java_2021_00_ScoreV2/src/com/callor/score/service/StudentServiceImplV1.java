package com.callor.score.service;

import com.callor.score.model.StudentVO;

public interface StudentServiceImplV1 {
	public void insertStudent();
	public void loadStudent();
	public StudentVO getStudent(String num);
	public void printStudent();
}
