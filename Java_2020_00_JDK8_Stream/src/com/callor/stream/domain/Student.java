package com.callor.stream.domain;

import java.util.Comparator;

public class Student implements Comparable<Student>{
		private String name;
		private int score;

		public Student(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return Integer.compare(score, o.score);
		}

}
