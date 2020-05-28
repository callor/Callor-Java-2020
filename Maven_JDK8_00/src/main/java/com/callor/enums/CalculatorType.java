package com.callor.enums;

import java.util.function.Function;

public enum CalculatorType {

	CALC_A(value->value),
	CALC_B(value->value*20);
	
	private Function<Long,Long> expression;
	private CalculatorType(Function<Long,Long> expression) {
		this.expression = expression;
	}
	public long calculate(long value) {return expression.apply(value);}
	
	
}
