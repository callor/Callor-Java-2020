package com.callor.array.student;

import java.util.Random;

public class Biz_403_2021_01 {

	public static void main(String[] args) {

		String[] strNames = new String[] { 
				"고은결", "기경헌", 
				"김기수", "김민식", "김성훈", "김소정", 
				"김영진", "나나", "노소연", "박성래", "박은빈",
				"방영두", "신어진", "오종관", "이민주", "이성민", 
				"이유빈", "이창준", "장혜미", "정류운", "조아영", 
				"조우석", "조혜승", "최건진", "최선영" 
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

		for (int i = 0; i < strNames.length; i++) {
			System.out.printf("%s\t", strNames[i]);
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
	}

}
