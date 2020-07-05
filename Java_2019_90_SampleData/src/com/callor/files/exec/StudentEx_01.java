package com.callor.files.exec;

import com.callor.files.service.StudentService;
import com.callor.files.service.StudentServiceImplV1;

public class StudentEx_01 {

	public static void main(String[] args) {
		
		StudentService sService = new StudentServiceImplV1();
		
		String nameFile = "src/com/callor/files/한국인성명리스트.txt";
		String addrFile = "src/com/callor/files/지방자치단체주소.txt";
		String studentFile = "src/com/callor/files/student.txt";
				
		try {
			sService.readNameList(nameFile);
			sService.readAddrList(addrFile);
			
			sService.writeStudentFile(studentFile, 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
