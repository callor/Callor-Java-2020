package com.callor.score.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;
import com.callor.score.values.Values;

public class StudentServiceImplV1 implements StudentService {

	private final String studentFileName;
	private List<StudentVO> stdList;

	public StudentServiceImplV1() {
		this("src/com/callorscor/exec/student.txt");
	}

	public StudentServiceImplV1(String studentFileName) {
		this.studentFileName = studentFileName;
		this.stdList = new ArrayList();
	}

	@Override
	public void loadStudentFromFile() {

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(studentFileName);
			buffer = new BufferedReader(fileReader);
			while (true) {

				String reader = buffer.readLine();
				if (reader == null)
					break;

				String students[] = reader.split(":");

				StudentVO stdVO = new StudentVO(students[0], students[1], students[2], students[3], students[4],
						students[5], students[6]);
				stdList.add(stdVO);
			}
			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void searchStudent() {

		Scanner scan = new Scanner(System.in);
		if (stdList.size() < 1) {
			System.out.println("학생 데이터가 Load 되지 않았습니다. 학생데이터를 먼저 Open 해 주세요");
			return;
		}
		while (true) {
			System.out.println(Values.dLine(30));
			System.out.println("===========================================");
			System.out.println("찾는 학생이름을 입력하세요(종료하려면 QUIT를 입력)");
			System.out.println(Values.sLine(30));
			System.out.println("이름 >> ");
			String strInputName = scan.nextLine();

			boolean bYesSearch = false;
			for (StudentVO stVO : stdList) {
				String stName = stVO.getStName();
				if (strInputName.trim().equals(stName)) {
					System.out.println(Values.dLine(50));
					System.out.printf("이름 : %s\n",stVO.getStName());
					System.out.printf("학과 : %s\n",stVO.getStDept());
					System.out.printf("학년 : %s\n",stVO.getStGrade());
					System.out.printf("반 : %s\n",stVO.getStClass());
					System.out.printf("주소 : %s\n",stVO.getStAddr());
					System.out.printf("전화번호 : %s\n",stVO.getStTel());
					System.out.println(Values.dLine(50));
					bYesSearch = true;
					break;
				}
			}
			if( !bYesSearch ) {
				System.out.println(Values.dLine(50));
				System.out.println(strInputName + "학생정보를 찾을 수 없습니다");
			}
		}
	}

}
