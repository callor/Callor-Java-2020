package com.callor.stream.input;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public class ConvertInputStream2StringJava8 {
	
	   public static void main(String[] args) throws IOException {

           String hello = "hello world";
           
           // import java.nio.charset.StandardCharsets;
           InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
           String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
           System.out.println(result);

   }

}
