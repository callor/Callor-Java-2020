package com.callor.system;

public class SystemLogerEx_01 {

	private static System.Logger LOGGER = System.getLogger(SystemLogerEx_01.class.getName());

	public static void main(String[] args) {
		LOGGER.log(System.Logger.Level.ALL, "Just a ALL message");
		LOGGER.log(System.Logger.Level.DEBUG, "Just a DEBUG message");
		LOGGER.log(System.Logger.Level.ERROR, "Just a ERROR message");
		LOGGER.log(System.Logger.Level.INFO, "Just a INFO message");
		LOGGER.log(System.Logger.Level.WARNING, "Just a WARNING message");
		
		LOGGER.log(System.Logger.Level.TRACE, "Just a TRACE message");
		
		
	}

}
