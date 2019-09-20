package com.biz.grade.exec;

import com.biz.grade.domain.StudentVO;
import com.biz.grade.service.StudentServiceV1;

public class StudentEx_02 {

	public static void main(String[] args) {

		StudentServiceV1 ss = new StudentServiceV1();
		String stdFileName = "src/com/biz/grade/학생명부.txt";
		
		try {
			ss.read(stdFileName);
			
			StudentVO stdVO = ss.getStudent("A001");
			if(stdVO != null) {
				System.out.println(stdVO.toString());
			}
			
			// ss 객체의 getStudent() 메서드를 실행하고
			// 그 결과(stdVO)에 toString() 메서드를 실행하라
			// class의 chainning 코딩
			System.out.println(ss.getStudent("A002").toString());

			// stdVO 객체를 받고
			// stdVO의 toString() method를 실행하는 코드를
			stdVO = ss.getStudent("A010");
			System.out.println(stdVO.toString());
			
			// class channing을 이용해서 한줄로 표현
			System.out.println(ss.getStudent("A010").toString());
			
			// A020 코드가 없으면 null을 표시
			System.out.println(ss.getStudent("A020"));
			
			// 해당 key값의 데이터(StudentVO)가 없을 경우
			// null 이라고 표시가 되거나,
			// exception이 발생할 수 있기 때문에
			// 미리 값이 정상적인지 검사하여
			// 그에 따른 적절한 처리를 수행한다.
			stdVO = ss.getStudent("A020");
			if(stdVO != null) {
				System.out.println(stdVO.toString());
			} else {
				System.out.println("A020 학생 없음!!");
			}
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
