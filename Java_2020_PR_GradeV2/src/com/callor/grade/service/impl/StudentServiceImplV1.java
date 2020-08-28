package com.callor.grade.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.grade.config.DBContract;
import com.callor.grade.config.Lines;
import com.callor.grade.domain.Student;
import com.callor.grade.service.StudentService;

public class StudentServiceImplV1 implements StudentService {

	protected List<Student> studentList;
	protected String fileName;
	protected Scanner scan;
	
	public StudentServiceImplV1() {
		this("src/com/callor/grade/exec/data/student.txt");
	}
	
	public StudentServiceImplV1(String fileName) {
		scan = new Scanner(System.in);
		studentList = new ArrayList<Student>();
		this.fileName = fileName;
	}
	
	@Override
	public void loadStudent(String studentFile) {
		this.fileName = studentFile ;
	}
	
	public void loadStudent() {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = "";
			while((reader = buffer.readLine()) != null) {
				
				// System.out.println(reader);
				
				String[] students = reader.split(":");
				Student student = new Student();
				
				student.setNum(students[ DBContract.STUDENT.ST_NUM ]);
				student.setName(students[ DBContract.STUDENT.ST_NAME ]);
				student.setGradeNum(Integer.valueOf(students[ DBContract.STUDENT.ST_GRADE ]));
				student.setDept(students[ DBContract.STUDENT.ST_DEPT ]);
				student.setTel(students[ DBContract.STUDENT.ST_TEL ]);
				
//				System.out.println(student);
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
	
	public boolean inputStudent() {
		
		Student student = new Student();	
		
		System.out.print("학번(END:종료)");
		String st_num = scan.nextLine();
		
		if(st_num.equals("END")) return false;
		
		int intNum = 0;
		try {
			intNum = Integer.valueOf(st_num);
		} catch (Exception e) {
			System.out.printf("입력한 문자열 %s\n",st_num);
			System.out.println("학번은 (5자리이내) 숫자로만 입력하세요");
			return true;
		}
		
		if(intNum < 1 || intNum > 99999) {
			System.out.printf("입력한 값 %d",intNum);
			System.out.println("학번은 1~99999 범위내에서 입력하세요");
			return true;
		}
		student.setNum(String.format("%05d",intNum));
		
		System.out.print("이름(END:종료)");
		String st_name = scan.nextLine();
		if(st_name.equals("END")) return false;
		student.setName(st_name);
		
		System.out.print("학과(END:종료)");
		String st_dept = scan.nextLine();
		if(st_dept.equals("END")) return false;
		student.setDept(st_dept);
		student.setDept(st_dept);

		System.out.print("학년(END:종료)");
		String st_grade = scan.nextLine();
		if(st_grade.equals("END")) return false;
		
		int intGrade = 0;
		try {
			intGrade = Integer.valueOf(st_grade);
		} catch (Exception e) {
			System.out.printf("입력한 문자열 %s\n",st_grade);
			System.out.println("학년은 (1자리) 숫자로만 입력하세요");
			return true;
		}
		
		if(intGrade < 1 || intGrade> 4) {
			System.out.printf("입력한 문자열 %s\n",st_grade);
			System.out.println("학년은 1~4 까지 1자리 숫자로만 입력하세요");
			return true;
		}
		student.setGradeNum(intGrade);
		
		System.out.print("전화번호(END:종료)");
		String st_tel = scan.nextLine();
		if(st_tel.equals("END")) return false;
		student.setTel(st_tel);
		
		studentList.add(student);
		System.out.println("리스트 추가완료!!!");
		return true;
	
	}
	
	public void saveFile() {
		
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(this.fileName);
			printWriter = new PrintWriter(fileWriter);
			
			for(Student student : studentList) {
				
				printWriter.printf("%s:%s:%s:%d:%s\n",
						student.getNum(),
						student.getName(),
						student.getDept(),
						student.getGradeNum(),
						student.getTel()
				);
			}
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
			System.out.println("학생명부 저장 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("학정정보를 저장하는 중 문제가 발생하였습니다!!!");
		}
	}
	
	
	public void studentList() {
		
		if(studentList == null || studentList.size() < 1) {
			System.out.println("★ ★ ★ 출력할 학생 명부가 없습니다");
			this.loadStudent();
			// return;
		};
		
		System.out.println(Lines.dLine);
		System.out.println("학생 일람표");
		System.out.println(Lines.dLine);
		System.out.println("학번\t|이름\t|학과\t|학년\t|전화번호\t|");
		System.out.println(Lines.sLine);
		
		for(Student student : studentList) {
			System.out.printf("%s\t|",student.getNum());
			System.out.printf("%s\t|",student.getName());
			System.out.printf("%s\t|",student.getDept());
			System.out.printf("%d\t|",student.getGradeNum());
			System.out.printf("%s\t|\n",student.getTel());
		}
		System.out.println(Lines.dLine);
		System.out.println("출력이 완료되었습니다 아무키나 누르세요.....");
		scan.nextLine();
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
