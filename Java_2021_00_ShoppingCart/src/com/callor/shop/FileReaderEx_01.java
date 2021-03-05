package com.callor.shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx_01 {
	
	public static void main(String[] args) {
		
		String fileName = "src/com/callor/shop/CartList.txt";
		try {
			FileReader fileReader = new FileReader(fileName);
			char[] reader = new char[1024];
			
			fileReader.read(reader);
			System.out.println(reader);
			
			fileReader.read(reader);
			System.out.println(reader);
			
			
			BufferedReader buffer = new BufferedReader(fileReader);
			
			fileReader.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
