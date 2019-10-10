package com.callor.pay.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaperReadServiceV1 {

	List<String> payStrList;
	
	public List<String> getPayStrList() {
		return this.payStrList;
	}
	
	public void read(String payFile) throws IOException {
		
		FileReader fileReader = new FileReader(payFile);
		BufferedReader buffer = new BufferedReader(fileReader);
		payStrList = new ArrayList<String>();
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null ) break;
			payStrList.add(reader);
		}
	}

}
