package com.callor.ref;

import java.lang.reflect.Method;
import java.util.Random;

public class ReflectionEx_01 {

	public static void main(String args[]) {

		try {
			Class c = Class.forName("java.util.Random");
			Method m[] = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

}
