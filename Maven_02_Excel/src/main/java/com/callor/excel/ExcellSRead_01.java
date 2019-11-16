package com.callor.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellSRead_01 {

	public static void main(String[] args) {

    	String exFile = "src/main/java/com/biz/excel/GRADE-학생정보(2019-10-10).xlsx";
    	FileInputStream file = null;
    	XSSFWorkbook workBook = null;
    	try {
			
    		file = new FileInputStream(exFile);
			workBook = new XSSFWorkbook(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	
    	// 학정정보 sheet 5,1번째(0번부터) 셀의 값을 읽어라
    	XSSFRow curRow = xSheet.getRow(5);
    	XSSFCell curCell = curRow.getCell(1);
    	
    	if(curCell != null) {
    		System.out.println(curCell.toString());
    	}

	}

}
