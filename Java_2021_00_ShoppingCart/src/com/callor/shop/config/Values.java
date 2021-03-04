package com.callor.shop.config;

public class Values {
	public static final String dLine;
	public static final String sLine;
	
	public final static Integer MENU_START = 1;
	public final static Integer MENU_LAST = 4;
	
	public final static Integer MENU_INPUT = 1;
	public final static Integer MENU_ALL_LIST = 2;
	public final static Integer MENU_USER_LIST = 3;
	public final static Integer MENU_SAVE = 4;
	
	
	static {
		dLine = String.format("%050d",0).replace("0", "=");
		sLine = String.format("%050d",0).replace("0", "=");
	}
}
