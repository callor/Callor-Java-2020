package com.callor.file.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelRead_01 {

	public static void main(String[] args) {

		// 반환용 리스트
		List<List<String>> ret = new ArrayList<List<String>>();
		BufferedReader br = null;
		String fileName = "src/com/callor/file/excel.csv";
		
		
		try {
			br = Files.newBufferedReader(Paths.get(fileName));
			Charset.forName("UTF-8");
			String line = new String();

			while (true) {
				
				line = br.readLine();
				if(line == null) break;
				// CSV 1행을 저장하는 리스트
				List<String> tmpList = new ArrayList<String>();
				String array[] = line.split(",");
				// 배열에서 리스트 반환
				tmpList = Arrays.asList(array);
				System.out.println(tmpList);
				ret.add(tmpList);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
