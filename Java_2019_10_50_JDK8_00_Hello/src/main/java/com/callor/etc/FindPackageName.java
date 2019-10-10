package com.callor.etc;

public class FindPackageName {

	public static void main(String[] args) {

		// Get package name of String class
		String str = new String();
		Package packs = str.getClass().getPackage();
		String packageName = packs.getName();
		System.out.println("Package Name = " + packageName);

		// Find current class name package
		FindPackageName o = new FindPackageName();
		packageName = o.getClass().getPackage().getName();
		System.out.println("Package Name = " + packageName);
	}

}
