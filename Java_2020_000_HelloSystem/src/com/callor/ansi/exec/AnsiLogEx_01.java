package com.callor.ansi.exec;

import com.callor.ansi.config.AnsiLog;

public class AnsiLogEx_01 {

	public static void main(String[] args) {
		
		String TAG = AnsiLogEx_01.class.getName();
		
		AnsiLog.i(TAG,"This is an info message");
		AnsiLog.e(TAG,"This is an error message");
		AnsiLog.w(TAG,"This is a warning message");
		AnsiLog.d(TAG,"This is a debug message");
	
	}
	
	
}
