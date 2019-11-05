package com.callor.grade.exec;

import java.util.List;
import java.util.Scanner;

import com.callor.grade.persistence.ScoreDTO;
import com.callor.grade.persistence.StudentDTO;
import com.callor.grade.service.ScoreService;
import com.callor.grade.service.ScoreServiceV1;
import com.callor.grade.service.StudentService;
import com.callor.grade.service.StudentServiceV1;

public class ScoreEx_03 {

	public static void main(String[] args) {

		StudentService st = new StudentServiceV1();
		ScoreService sc = new ScoreServiceV1();
		
		Scanner scanner = new Scanner(System.in);
	
		while(true) {
			System.out.println("======================");
			System.out.println("내맘대로 성적처리");
			System.out.println("======================");
			System.out.print("학생이름 >> ");
			String strName = scanner.nextLine();
			
			List<StudentDTO> stdList = st.findByName(strName);
			
			// 학생을 못찾으면 stdList 가 null 값이 되어야 하는데
			// = new ArrayList() 생성을 하면
			// null 아닌 size()가 0인 값이 return 되기 때문에
			// null 이거나 size() < 1 인 경우를 검사
			if(stdList == null || stdList.size() < 1) {

				System.out.println("찾는 학생이 없음!!");
				continue;
			
			}

			for(StudentDTO sDTO : stdList) {
				
				// 학생정보리스트의 현재값을 검사해
				// debuggin용 코드
				System.out.println(sDTO.toString());
				
				List<ScoreDTO> scList 
					= sc.findByName(sDTO.getSt_num());
				if(scList != null) {
					for(ScoreDTO scDTO : scList) {
						System.out.println(scDTO.toString());
					}
				}
				
			}
		}
	}

}
