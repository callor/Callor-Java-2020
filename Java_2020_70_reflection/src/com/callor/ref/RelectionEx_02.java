package com.callor.ref;

import java.lang.reflect.Method;

public class RelectionEx_02 {

	// 이름으로 메쏘드 실행하기.

	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String args[]) {
		try {
			Class cls = Class.forName("com.callor.ref.RelectionEx_02");
			Class partypes[] = new Class[2];
			
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			
			Method meth = cls.getMethod("add", partypes);
			RelectionEx_02 methobj = new RelectionEx_02();
			Object arglist[] = new Object[2];

			Object retobj = meth.invoke(methobj, arglist);
			Integer retval = (Integer) retobj;
			System.out.println(retval.intValue());

		} catch (Throwable e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}

}
