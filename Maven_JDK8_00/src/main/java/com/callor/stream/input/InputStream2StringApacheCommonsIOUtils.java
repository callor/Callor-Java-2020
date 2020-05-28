package com.callor.stream.input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;


/*
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.6</version>
</dependency>
*/

public class InputStream2StringApacheCommonsIOUtils {
	public static void main(String[] args) throws IOException {

        String hello = "hello world";
        InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
        
        // import org.apache.commons.io.IOUtils;
        String result = IOUtils.toString(is, StandardCharsets.UTF_8);
        System.out.println(result);

}

}
