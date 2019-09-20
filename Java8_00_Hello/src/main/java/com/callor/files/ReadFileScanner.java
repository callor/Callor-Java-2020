package com.callor.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileScanner {

	// Java Scanner Class Example
	public static void main(String[] args) throws FileNotFoundException {

		// Creating File Object
		File file = new File("src/main/java/com/callor/files/한국연예인.txt");

		// Creating Scanner Object
		@SuppressWarnings("resource")
		Scanner scan  = new Scanner(file);

		// Reading each line of file using Scanner class
		int lineNum = 1;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			System.out.println(lineNum + " :" + line);
			lineNum++;
		}

	}

}
