package com.callor.dateString;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class FindAllMonthsInJava {

	/**
	 * Get All Months / Short Months / Locale Months In Java
	 */
	public static void main(String[] args) {
		// Get List of Month Names
		System.out.println("All Months: " + Arrays.toString(new DateFormatSymbols().getMonths()));
		// Get List of Short Month Name
		System.out.println("Short Months: " + Arrays.toString(new DateFormatSymbols().getShortMonths()));
		// Get List of Month Names Using Locale
		System.out
				.println("All Months In French: " + Arrays.toString(new DateFormatSymbols(Locale.FRENCH).getMonths()));
		// Get List of Short Month Name Using Locale
		System.out.println(
				"Short Months In French: " + Arrays.toString(new DateFormatSymbols(Locale.FRENCH).getShortMonths()));
	}

}
