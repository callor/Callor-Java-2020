package com.callor.java9;

public class SystemEx_01 {

	// JDK 9 이상에서 사용가능한 System.Logger
	private static System.Logger LOGGER = System.getLogger(SystemLogerEx_01.class.getName());

	public static void main(String[] args) {
		LOGGER.log(System.Logger.Level.ALL, "Just a ALL message");
		LOGGER.log(System.Logger.Level.DEBUG, "Just a DEBUG message");
		LOGGER.log(System.Logger.Level.ERROR, "Just a ERROR message");
		LOGGER.log(System.Logger.Level.INFO, "Just a INFO message");
		LOGGER.log(System.Logger.Level.WARNING, "Just a WARNING message");
//			
		LOGGER.log(System.Logger.Level.TRACE, "Just a TRACE message");

		System.out.println("대한민국 만세");

	}

}
