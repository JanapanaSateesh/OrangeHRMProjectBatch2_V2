package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcleCls2 {
	
	public static String[][] getData(String filepath) throws IOException {
		File excelfile = new File(filepath); //   "./TestData/TestDataForTitleValidation.xlsx"
		FileInputStream fi= new FileInputStream(excelfile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet  sheet = workbook.getSheet("Sheet1");
		
		int numberofrows= sheet.getPhysicalNumberOfRows();
		int numberofcolumns= sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[numberofrows-1][numberofcolumns];
					//3<=2
		for(int i=0;i<numberofrows-1;i++) { 
						//1<2
			for(int j=0;j<=numberofcolumns-1;j++) { 
				DataFormatter df = new DataFormatter();
				data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));//00=10,01=11,02=
				System.out.println("row :"+i+"col:"+j+" "+data[i][j]);
				
			}
		}
		fi.close();
		return data;
		
	}
	
	
	public static void main(String args[]) throws IOException {
		getData("./TestData/TestDataForTitleValidation.xlsx");
		
	}

}
