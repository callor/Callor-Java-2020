package com.callor.json;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
	<dependency>
	<groupId>com.google.code.gson</groupId>
	<artifactId>gson</artifactId>
	<version>2.8.5</version>
	</dependency>
*/
public class GoogleJSonList {

	public static void main(String[] args) {

		// Configure gson
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		// Convert List of string into JSON
		List<String> strList = new LinkedList<String>();
		strList.add("How");
		strList.add("Are");
		strList.add("You");
		System.out.println("JSON String List " + gson.toJson(strList));

		// Convert List of Object into JSON
		List<StudentVO> studentList = new LinkedList<StudentVO>();
		StudentVO student1 = new StudentVO("Sandra", "Jose");
		StudentVO student2 = new StudentVO("Sony", "Jose");
		studentList.add(student1);
		studentList.add(student2);
		System.out.println("JSON Object List " + gson.toJson(studentList));

	}

}
