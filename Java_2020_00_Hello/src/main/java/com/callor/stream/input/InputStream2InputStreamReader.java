package com.callor.stream.input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class InputStream2InputStreamReader {

    public static void main(String[] args) throws IOException {
            String hello = "hello world";
            InputStream is = new ByteArrayInputStream(hello.getBytes(StandardCharsets.UTF_8));
            final int buffSize = 1024;
            final char[] buff = new char[buffSize];
            final StringBuilder result = new StringBuilder();
            Reader in = new InputStreamReader(is, "UTF-8");
            int read;
            while ((read = in.read(buff, 0, buff.length)) != -1) {
                    result.append(buff, 0, read);
            }
            System.out.println(result);

    }
}