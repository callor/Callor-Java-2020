package com.callor.hello;

import java.util.Arrays;

// Run As, Run Configuration, Argument, ${string_prompt}
public class RunArgs {
	public static void main(String[] args) {
		
		for(String str : args) {
			System.out.println(str);
		}
		
		System.out.println(Arrays.toString(args));
		System.out.println(30 + 40);
	}
}
