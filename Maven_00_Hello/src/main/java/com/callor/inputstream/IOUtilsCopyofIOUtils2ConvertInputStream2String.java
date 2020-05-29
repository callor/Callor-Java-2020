package com.callor.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
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
public class IOUtilsCopyofIOUtils2ConvertInputStream2String {

	public static void main(String[] args) throws IOException {

		String hello = "hello world";
		InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
		StringWriter result = new StringWriter();
		
		// import org.apache.commons.io.IOUtils;
		IOUtils.copy(is, result, "UTF-8");
		System.out.println(result);

	}

}
