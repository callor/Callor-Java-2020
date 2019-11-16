package com.callor.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelAllRead_01 
{
    public static void main( String[] args )
    {
    	
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
    	
    	int rowIndex = 0;
    	int colIndex = 0;
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	
    	// 현재 열린 sheet(학생정보)의 데이터가 저장된 row 개수를 가져와라
    	int rows = xSheet.getPhysicalNumberOfRows();
    	for(rowIndex = 0 ; rowIndex < rows ; rowIndex++) {
    		
    		// 현재 sheet에서 rowIndex 위치의 row 한줄을 읽어와라
    		XSSFRow curRow = xSheet.getRow(rowIndex);
    		
    		// 현재 row에 데이터가 저장된 column 개수를 가져와라
    		int cols = curRow.getPhysicalNumberOfCells();
    		
    		for(colIndex = 0 ; colIndex < cols ; colIndex++) {
    			
    			// 한칸의 데이터를 가져와라
    			XSSFCell cell = curRow.getCell(colIndex);
    			if(cell == null) continue; // 비어있는 칸은 skip
    			else {
    				System.out.print(cell.toString() + "\t");
    			}
    		}
    		System.out.println();
    	}
        System.out.println( "Hello World!" );
    }
}
