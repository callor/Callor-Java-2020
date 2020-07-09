package com.callor.files.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StudentServiceImplV1 implements StudentService{

	private FileReader fileReader = null;
	private BufferedReader bufferReader = null;
	
	private FileWriter fileWriter = null;
	private PrintWriter outPut = null;
	
	private List<String> nameList;
	private List<String> addrList;
	
	private String[] deptArray;	
	
	public StudentServiceImplV1() {
		nameList = new ArrayList<String>();
		addrList = new ArrayList<String>();
		deptArray =  new String[]{"컴퓨터공학","전자공학","국어국문","역사학","영어영문","법학","경제학"};
	}

	@Override
	public void readNameList(String nameFile) throws Exception {

		fileReader = new FileReader(nameFile);
		bufferReader = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			
			reader = bufferReader.readLine();
			if(reader == null) break;
			nameList.add(reader);
		}
		bufferReader.close();
		fileReader.close();
		
		//========== debuging code ========
		for(String s : nameList) {
			System.out.println(s);
		}
		//==================================
		
		
	}

	@Override
	public void readAddrList(String addrFile) throws Exception {

		fileReader = new FileReader(addrFile);
		bufferReader = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			
			reader = bufferReader.readLine();
			if(reader == null) break;
			String[] addrs = reader.split(":");
			addrList.add(addrs[2]);
		}
		bufferReader.close();
		fileReader.close();
		
		//========== debuging code ========
		for(String s : addrList) {
			System.out.println(s);
		}
		//==================================
		
	}

	@Override
	public void writeStudentFile(String studentFile, int length) throws Exception {

		List<String> studentList = new ArrayList<String>();
		
		Collections.shuffle(addrList);
		Collections.shuffle(nameList);
		
		Random rnd = new Random();
		
		fileWriter = new FileWriter(studentFile);
		outPut = new PrintWriter(fileWriter);
		
		int size = addrList.size();
		size = size > nameList.size() ? nameList.size() : size;
		
		for(int i = 0 ; i < size ; i++) {
		
			int grade = rnd.nextInt(4) + 1;
			int classNum = rnd.nextInt(10) + 1;
			String name = nameList.get(i);
			String addr = addrList.get(i);
			String dept = deptArray[ rnd.nextInt( deptArray.length )];
			String tel = String.format("010-%04d-%04d",rnd.nextInt(9999) +1,rnd.nextInt(9999) +1);
			
			// 학번, 이름, 전공, 학년, 반, 주소, 전화번호
			String student = String.format("%05d:%s:%s:%d:%d:%s:%s", 
					i+1,name,dept,grade,classNum,addr,tel);
			
			System.out.println(student);
			studentList.add(student);
			
			
		}
		
		Collections.shuffle(studentList);
		
		for(String student: studentList) {
			outPut.println(student);	
		}
		outPut.close();
		fileWriter.close();
		
	}
	
}
