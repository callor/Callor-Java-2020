package com.callor.stream.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ByteArrayOutputStreamEx {
	
	
	 public static void main(String[] args) throws IOException {

         String hello = "hello world";
         InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
         ByteArrayOutputStream buffer = new ByteArrayOutputStream();
         int read;
         byte[] buff = new byte[1024];
         while ((read = is.read(buff, 0, buff.length)) != -1) {
                 buffer.write(buff, 0, read);
         }
         buffer.flush();
         byte[] byteArray = buffer.toByteArray();
         String result = new String(byteArray, StandardCharsets.UTF_8);
         System.out.println(result);

 }

}
