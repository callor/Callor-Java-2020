package com.callor.enums;

public class Exec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyVO vo = new MyVO();
		
		vo.strString = MyStr.나는자랑스러운.toString();
		vo.strString = String.valueOf(MyStr.태극기앞에);
		
		System.out.println(vo.strString);
		
		vo.strEnum = MyStr.우리나라만세;
		System.out.println(vo);
		
		
		 System.out.println(String.valueOf(CalculatorType.CALC_A.calculate(10)));
		 System.out.println(String.valueOf(CalculatorType7.CALC_B.calculator(10)));
		
	}

}
