package com.callor.iolist.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class IolistServiceImpV1 implements IolistService {

	/*
	 * fileName 파일을 읽어서 한줄씩 console에 보이시오
	 */
	@Override
	public void read(String fileName) throws Exception {

		FileReader fileReader;
		BufferedReader buffer;
		
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null)break;
			System.out.println(reader);
		}
		
		buffer.close();
		fileReader.close();
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void summany() {
		// TODO Auto-generated method stub

	}

}
