package com.callor.score.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.callor.score.model.StudentVO;

public class StudentServiceImplV1 implements StudentService {
	
	protected String studentFileName;
	protected List<StudentVO> studentList;
	protected final int 학번 = 0;
	protected final int 이름 = 1;
	protected final int 학년= 2;
	protected final int 반 = 3;
	protected final int 학과 = 4;
	protected final int 주소 = 5;
	
	{
		
	}
	public StudentServiceImplV1() throws IOException {
		this("src/com/callor/score/student.txt");
	}
	
	public StudentServiceImplV1(String studentFileName) throws IOException {
		this.studentFileName = studentFileName;
		this.studentList = new ArrayList<StudentVO>();
		this.loadStudent();
	}

	@Override
	public void loadStudent() throws IOException {
		// TODO 파일에서 학생 정보 읽어 오기
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		fileReader = new FileReader(this.studentFileName);
		buffer = new BufferedReader(fileReader);
		
		String reader = null;
		while( (reader = buffer.readLine()) != null) {
			
			String students[] = reader.split(":");
			StudentVO stVO = new StudentVO();
			stVO.setNum(students[학번]);
			stVO.setName(students[이름]);
			stVO.setGrade(students[학년]);
			stVO.setDept(students[학과]);
			stVO.setAddress(students[주소]);
			studentList.add(stVO);
		}
		buffer.close();
	}

	@Override
	public void insertStudent() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public StudentVO getStudent(String num) {
		// TODO 학번으로 학생정보 검색
		
		for(StudentVO vo : studentList) {
			if(vo.getNum().equals(num)) return vo;
		}
		return null;
	
	}

	@Override
	public void printStudent() {
		// TODO 학생정로 전체 출력
		
		System.out.println("=".repeat(80));
		System.out.println("학번\t이름\t학과\t학년\t주소");
		System.out.println("-".repeat(80));
		for(StudentVO vo : studentList) {
			
			System.out.print(vo.getNum() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getDept() + "\t");
			System.out.print(vo.getGrade() + "\t");
			System.out.print(vo.getAddress() + "\n");
		}
		System.out.println("=".repeat(80));
	}

}
