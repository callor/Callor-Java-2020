package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy_01 {

	public static void main(String[] args) throws IOException {

		String imgSrcFile = "src/com/biz/stream/2019_97886-2080.jpg";
		String imgCopyFile = "src/com/biz/stream/2019_97886-2080-Copy.jpg";
		
		InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(imgSrcFile);
	        os = new FileOutputStream(imgCopyFile);
	        byte[] buffer = new byte[1024];
	        int length;
	        // while ((length = is.read(buffer)) > 0) {
	        while (true) {
	        	length = is.read(buffer);
	        	if(length < 1) break;
	            os.write(buffer, 0, length);
	        }
	    
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        is.close();
	        os.close();
	    }
		System.out.println("File Ok!!");
	}

}
