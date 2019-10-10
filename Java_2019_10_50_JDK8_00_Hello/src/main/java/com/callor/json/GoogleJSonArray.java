package com.callor.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
	<dependency>
	<groupId>com.google.code.gson</groupId>
	<artifactId>gson</artifactId>
	<version>2.8.5</version>
	</dependency>
*/
public class GoogleJSonArray {

	public static void main(String[] args) {

		// Configure gson
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		// Convert Array of String into JSON
		String[] strArray = new String[2];
		strArray[0] = "Good";
		strArray[1] = "Morning";
		System.out.println("JSON String Array " + gson.toJson(strArray));

		// Convert Array of Object into JSON
		StudentVO[] studentArray = new StudentVO[2];
		studentArray[0] = new StudentVO("Rony", "Jose");
		studentArray[1] = new StudentVO("Aby", "Jose");
		System.out.println("JSON Object Array " + gson.toJson(studentArray));

	}

}
