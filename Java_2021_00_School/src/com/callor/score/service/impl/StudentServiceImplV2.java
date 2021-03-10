package com.callor.score.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.callor.score.model.StudentVO;
import com.callor.score.values.Values;

public class StudentServiceImplV2 extends StudentServiceImplV1 {

	private Scanner scan;

	public StudentServiceImplV2() {
		this("src/com/callor/score/exec/student.txt");
	}

	public StudentServiceImplV2(String fileName) {
		System.out.println("V2");
		this.studentFileName = fileName;
		stdList = new ArrayList<StudentVO>();
		scan = new Scanner(System.in);
	}

	@Override
	public void searchStudent() {

		if (stdList.size() < 1) {
			System.out.println("학생 데이터가 Load 되지 않았습니다. 학생데이터를 먼저 Open 해 주세요");
			return;
		}
		while (true) {
			System.out.println(Values.dLine(50));
			System.out.println("찾는 학생이름을 입력하세요(종료하려면 QUIT를 입력)");
			System.out.println(Values.sLine(50));
			System.out.print("이름 >> ");
			String strInputName = this.scan.nextLine();
			if(strInputName.equals("QUIT")) {
				break;
			}

			boolean bYesSearch = false;
			for (StudentVO stVO : stdList) {
				String stName = stVO.getStName();
				if (strInputName.trim().equals(stName)) {
					this.printStVO(stVO);
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
