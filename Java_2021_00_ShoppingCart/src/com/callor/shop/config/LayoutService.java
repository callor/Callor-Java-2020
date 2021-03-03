package com.callor.shop.config;

public class LayoutService {
	public static final String dLine;
	public static final String sLine;
	static {
		dLine = String.format("%050d",0).replace("0", "=");
		sLine = String.format("%050d",0).replace("0", "=");
	}
}
