package com.callor.etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.callor.files.Files;

/*
 * Java 에서 운영체제 Command 실행하기
 */
public class JavaProcessBuilder {
	
	
    public static void main(String[] args) throws IOException {
        List<String> command = new ArrayList<String>();

        // For linux
//        command.add("uptime");
      
        // For windows
         command.add("notepad.exe");
         command.add(Files.W연습파일);
       
        ProcessBuilder processbuilder = new ProcessBuilder(command);
        
        // Redirect output to this file.
        processbuilder.redirectOutput(new File("1"));

        final Process process = processbuilder.start();
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = new String();
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        
        
        // waitFor() method is used to wait till the process returns the exit value
        try {
            int exitValue = process.waitFor();
            System.out.println("Exit Value is " + exitValue);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        System.out.println("Program terminated!");
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        
        
        command.clear();
        
    }

}
