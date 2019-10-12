package com.biz.lombok.exec;

import java.util.ArrayList;
import java.util.List;

import com.biz.lombok.domain.StudentVO;

public class StudentEx_01 {

	public static void main(String[] args) {

		List<StudentVO> stdList1 = new ArrayList<StudentVO>();
		List<StudentVO> stdList2 = new ArrayList<StudentVO>();
		int count = 10000000;

		long start = System.currentTimeMillis();
		System.out.println("start : " +start);
		for (int i = 0; i < count ; i++) {
			StudentVO sVo = new StudentVO();
			sVo.setS_num("001");
			sVo.setS_name("홍길도");
			sVo.setS_tel("010");
			stdList1.add(sVo);
		}

		long end = System.currentTimeMillis();
		System.out.println("end : " +end);
		System.out.println("경과 : " + (end - start));

		// System.out.println(sVo.toString());

		start = System.currentTimeMillis();
		System.out.println("start : " +start);
		for(int i = 0 ;  i < count ; i++) {
			
			/*
			stdList2.add(StudentVO.builder().s_num("001").build());
			stdList2.add(StudentVO.builder().s_num("001").s_name("홍길동").build());
			stdList2.add(StudentVO.builder().s_num("001").s_tel("010").build());
			stdList2.add(StudentVO.builder().s_num("001").s_addr("우리집").build());
			*/
			stdList2.add(StudentVO.builder().s_num("001").s_name("우리집").s_tel("010").build());
		}
		end = System.currentTimeMillis();
		System.out.println("end : "+end);
		System.out.println("경과 : " + (end - start));

	}
}
