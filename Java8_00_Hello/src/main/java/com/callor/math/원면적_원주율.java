package com.callor.math;


/*
 * 자바 원주율 구하기
 */
public class 원면적_원주율 {

	 public static void main(String args[]) {
	        int radius = 124;
	        // Area = radius*radius*PI
	        double area = (radius * radius) * Math.PI;
	        System.out.println("원면적 : " + area);
	        // Circumference = PI*radius*2
	        double circumference = radius * Math.PI * 2;
	        System.out.println("원주 : " + circumference);
	    }
	
	
}
