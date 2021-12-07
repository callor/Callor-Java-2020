package com.callor.app.filewriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KeyInputToPrintWriter {
	
	
	public static void main(String[] args) throws IOException{
		   
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out =
                new PrintWriter(new BufferedWriter(new FileWriter("src/com/callor/app/keyIn.txt")));
       
        
        System.out.println("문자열을 입력하세요");
        while( true  ){
        	String line = buffer.readLine();
        	if(line.equals("END")) break;
            System.out.println(line);
            out.println(line);          
        }
        out.close();
        buffer.close();
    }

}
