package com.callor.files.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderService {
	
	FileReader fileReader = null;
	BufferedReader buffer = null;
	
	public void read(String fileName) throws IOException {
		
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);
		
		String strReader = buffer.readLine();
		System.out.println(strReader);
		
	}

}
