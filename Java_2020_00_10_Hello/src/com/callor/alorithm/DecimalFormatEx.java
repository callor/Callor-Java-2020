package com.callor.alorithm;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	
	public static void main(String[] args) {
		
		long intNum = 39234432455599932L;
		DecimalFormat decForm = new DecimalFormat();
		decForm.applyPattern("###,###");
		System.out.println(decForm.format(intNum));
		
		// System.out.println(Long.toString(intNum).replaceAll("\\d{3}+", ","));
		
	}
}
