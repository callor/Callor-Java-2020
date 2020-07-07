package com.callor.files.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class WordEx_01 {

	public static void main(String[] args)  {
		
		String wordFile = "src/com/callor/files/필수어휘.txt";
		String word3File = "src/com/callor/files/5word.txt";

		Random rnd = new Random();
		// PrintWriter outPut = null;
		PrintStream outPut = System.out;
		FileReader fileReader = null;
		BufferedReader  buffer = null;
		
		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);
			outPut = new PrintStream(word3File);
			
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				String words[] = reader.split(":");
				if(words[1].length() > 5) {
					String word = String.format("%s:%s", words[1],words[2]);
					outPut.println(word);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outPut.close();
		System.out.println("작성완료!!");

	}

}
