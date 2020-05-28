package com.biz.lombok.service;

import java.util.List;

import com.biz.lombok.domain.StudentVO;

import lombok.Getter;

public class StudentReadServiceV1 {
	
	private List<StudentVO> stdList;

	public List<StudentVO> getStdList() {
		return this.stdList;
	}
	
	/*
	 * 파일로부터 학생정보를 읽어서 stdList에 저장
	 */
	public void readStudent(String fileName) {
		
	}

}
