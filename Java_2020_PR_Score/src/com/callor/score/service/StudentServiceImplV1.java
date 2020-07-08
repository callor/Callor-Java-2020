package com.callor.score.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.callor.config.DBContract;
import com.callor.score.domain.Student;

public class StudentServiceImplV1 implements StudentService {

	List<Student> studentList;
	
	public StudentServiceImplV1() {
		studentList = new ArrayList<Student>();
	}
	
	public void loadStudent(String fileName) {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = "";
			while((reader = buffer.readLine()) != null) {
				
				String[] students = reader.split(":");
				Student student = new Student();
				
				student.setNum(students[ DBContract.STUDENT.ST_NUM ]);
				student.setName(students[ DBContract.STUDENT.ST_NAME ]);
				student.setGradeNum(Integer.valueOf(students[ DBContract.STUDENT.ST_GRADE ]));
				student.setDept(students[ DBContract.STUDENT.ST_DEPT ]);
				student.setAddr(students[ DBContract.STUDENT.ST_DEPT ]);
				
				studentList.add(student);
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("학생정보파일 loading 오류!!!");
		} catch (IOException e) {
			System.out.println("학생정보파일 읽기 오류!!!");
		}
	}
	
	public Student findByNum(String num) {
		for(Student s : studentList) {
			if(s.getNum().equals(num)) {
				return s;
			}
		}
		return null;
	}
}
