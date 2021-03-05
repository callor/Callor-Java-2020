package com.callorscor.values;

public class Values {
	
	public static final String dLine;
	public static final String sLine;
		
	public static final Integer MENU_MAKE = 1;
	public static final Integer MENU_SAVE = 2;
	public static final Integer MENU_PRINT = 3;
	
	public static final Integer MENU_START = MENU_MAKE;
	public static final Integer MENU_LAST= MENU_PRINT;
	
	static {
		dLine = String.format("%050d",0).replace("0", "=");
		sLine = String.format("%050d",0).replace("0", "=");
	}
	

}
