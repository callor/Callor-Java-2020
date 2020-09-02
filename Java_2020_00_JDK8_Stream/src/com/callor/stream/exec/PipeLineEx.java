package com.callor.stream.exec;

import java.util.Arrays;
import java.util.List;

import com.callor.stream.domain.Member;
import com.callor.stream.domain.MemberEnum;

public class PipeLineEx {
		public static void main(String[] args) {
		    List<Member> list = Arrays.asList(
		        new Member("홍길동", MemberEnum.MALE, 30),
		        new Member("김나리", MemberEnum.FEMALE, 20),
		        new Member("김남준", MemberEnum.MALE, 25),
		        new Member("박수미", MemberEnum.FEMALE, 28)
		    );

		    double avg = list.stream()
		        .filter(m -> m.getSex() == MemberEnum.MALE)
		        .mapToInt(Member::getAge)
		        .average()
		        .getAsDouble();
		    System.out.println(avg);
		  }

}


