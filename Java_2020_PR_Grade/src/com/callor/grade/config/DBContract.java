package com.callor.grade.config;

public class DBContract {

	// 학번, 이름, 전공, 학년, 전화번호
	public static class STUDENT {
		public static final int ST_NUM = 0;
		public static final int ST_NAME = 1;
		public static final int ST_DEPT = 2;
		public static final int ST_GRADE = 3;
		public static final int ST_TEL = 4;

	}

	public static class SCORE {
		public static final int SC_NUM = 0;
		public static final int SC_KOR = 1;
		public static final int SC_ENG = 2;
		public static final int SC_MATH = 5;
		public static final int SC_MUSIC = 6;
		public static final int SC_SUM = 6;
		public static final int SC_AVG = 6;
	}
	
}
