package com.callor.exam.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex_09 {

	public static void main(String[] args) {

		String fileName = "data.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			// String reader = ""
			String reader = new String();
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				System.out.println(reader);
			}
			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일을 읽을 수 없습니다");
		}

	}

}
