package com.callor.array.student;

import java.util.Random;

public class SpringMVC_2021_03 {

	public static void main(String[] args) {

		String[] strNames = new String[] { "김**", "김**", "김**", "김**", "범**", 
				"유**", "은**", "이**", "임**", "임**", "정**",
				"조**", "최**", "한**" };

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

		System.out.println("조**,정**,오**");
		System.out.println("구**,박**,길**,한**");
		for (int i = 0; i < strNames.length; i++) {

			System.out.printf("%s,", strNames[i]);
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
	}

}
