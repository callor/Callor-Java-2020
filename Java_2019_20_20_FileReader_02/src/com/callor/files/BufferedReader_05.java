package com.callor.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.callor.files.model.StudentVO;

public class BufferedReader_05 {

	/*
	 * 영어이름들. txt 파일을 읽어서
	 * 각 라인을 : 기준으로 자른 후
	 * sVO 리스트에 추가하시오
	 * 1:Korea:대한민국
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nameFile = "src/com/callor/files/영어이름들.txt";
		
		List<StudentVO> sVO = new ArrayList<StudentVO>();
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(nameFile);
			buffer = new BufferedReader(fr);
			while(true) {
				String strLine = buffer.readLine();
				if(strLine == null) break;
				
				String[] strNames = strLine.split(":");
				if(strNames.length > 2) {
					
					StudentVO vo = new StudentVO();
					vo.setStrNum(strNames[0]);
					vo.setStrEngName(strNames[1]);
					vo.setStrKorName(strNames[2]);
					sVO.add(vo);

				}
			}
			buffer.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(StudentVO vo : sVO) {
			System.out.println(vo);
		}
		
		
		
		

	}

}
