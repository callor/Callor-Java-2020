package com.callor.array.student;

import java.util.Random;

public class Biz_403_2021_04 {

	public static void main(String[] args) {

		String[] strNames = new String[] { 
				"김민식","신어진","이민주","이성민","정류운" 
				};

		Random rnd = new Random();

		for (int i = 0; i < strNames.length; i++) {
			for (int j = i; j < strNames.length; j++) {

				int index1 = rnd.nextInt(strNames.length);
				int index2 = rnd.nextInt(strNames.length);

				String temp = strNames[index1];
				strNames[index1] = strNames[index2];
				strNames[index2] = temp;
			}
		}

		System.out.println("=".repeat(50));
		System.out.println("프로그래밍 언어활용 팀프로젝트");
		System.out.println("=".repeat(50));
		System.out.println("노소연\t고은결\t김영진\t나나\t박은빈");
		System.out.println("조아영\t김소정\t이유빈\t장혜미\t최선영");
		System.out.println("최건진\t김기수\t기경헌\t오종관\t조우석");
		System.out.println("김성훈\t이창준\t방영두\t박성래\t조혜승");
		System.out.println("t신어진\t김민식\t이민주\t이성민\t정류운");
		System.out.println("=".repeat(50));
		
		for (int i = 0; i < strNames.length; i++) {
			System.out.printf("%s\t", strNames[i]);
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println("=".repeat(50));
	}

}
