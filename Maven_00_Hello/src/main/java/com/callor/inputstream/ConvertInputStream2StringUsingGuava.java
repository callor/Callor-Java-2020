package com.callor.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

/*
<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>27.0.1-jre</version>
</dependency>
*/

public class ConvertInputStream2StringUsingGuava {
	
	
	   public static void main(String[] args) throws IOException {

           String hello = "hello world";
           InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
           
           // import com.google.common.base.Charsets;
           // import com.google.common.io.CharStreams;
           String result = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));
           System.out.println(result);

           
   }

}
