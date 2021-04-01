package com.callor.enums;

public enum CalculatorType7 {

	CALC_A {
		long calculator(long value) {return value;}
	},
	CALC_B {
		long calculator(long value) {return value*10;}
	};
	abstract long calculator(long value) ;
	
	
}
