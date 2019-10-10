package com.callor.stream.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ObjectEx_02 {

	public static void main(String[] args) {

		String objSaveFile = "src/com/callor/stream/obj.dat";
		
		InputStream is = null;
		ObjectInput obj = null;
		
		try {
			
			is = new FileInputStream(objSaveFile);
			obj = new ObjectInputStream(is);
			String strName = (String)obj.readObject();
			String strNation = (String)obj.readObject();
			Integer intYear = (Integer)obj.readObject();
			
			System.out.println("strName : " + strName);
			System.out.println("strNation : " + strNation);
			System.out.println("intYear : " + intYear);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
