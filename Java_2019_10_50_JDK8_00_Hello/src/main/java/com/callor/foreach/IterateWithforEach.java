package com.callor.foreach;

import java.util.EnumSet;
import java.util.stream.Stream;

public class IterateWithforEach {
	
	
	 public enum DaysOfWeek {
			SUNDAY, MONDAY, TUESDAY, WEBNESDAY, THRUSDAY, FRIDAY, SATURDAY
		    }
	
	public static void main(String[] args) {
		
		// iterate using forEach
		EnumSet.allOf(DaysOfWeek.class)
		  .forEach(day -> System.out.println(day));


		
		// iterate using stream
		Stream.of(DaysOfWeek.values()).forEach(System.out::println);
		
		// iterate using for
		for (DaysOfWeek day : DaysOfWeek.values()) { 
		    System.out.println(day); 
		}

	}

}
