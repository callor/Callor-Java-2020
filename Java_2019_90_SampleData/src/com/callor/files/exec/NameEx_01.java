package com.callor.files.exec;

import com.callor.files.service.NameService;
import com.callor.files.service.NameServiceImplV1;

public class NameEx_01 {

	public static void main(String[] args) {
		/*
		 * 이름리스트.txt와 성씨리스트.txt 파일을 읽어서 
		 * 		리스트를 만들고
		 * 두 리스트의 값들을 임의 조합하여
		 * 3글자의 한국사람 이름을 생성하고
		 * 한국인이름.txt 파일로 저장하시오
		 * 
		 * 단, 
		 * 1. 성씨는 한자는 제외하고 한글1자만 사용
		 * 2. 한국인이름 리스트는 100개를 작성하시오
		 * 
		 * 3. 이름리스트.txt에 나오는 이름순서와
		 * 		성씨리스트.txt에 나오는 성씨순서가 
		 * 		일치하지 않도록 하시오
		 * 
		 * 4. Service 클래스를 작성하여 과제를 수행하시오
		 */
		
		String nameFile = "src/com/callor/files/이름리스트.txt";
		String famFile = "src/com/callor/files/성씨리스트.txt";
		String korNameFile = "src/com/callor/files/한국인성명리스트.txt";
		
		NameService ns = new NameServiceImplV1();
		
		
		try {
			ns.readNameList(nameFile);
			ns.readFamList(famFile);
			ns.writeNameFile(korNameFile,10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
