package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginPage {
	
	@DataProvider(name = "getData")
	public String[][] getData() throws IOException {
		File excelfile = new File("./src/test/resources/Data.xlsx");
		System.out.println(excelfile.exists());
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int noofRows =  sheet.getPhysicalNumberOfRows();
		int noOfColoumn = sheet.getRow(0).getLastCellNum();
		String [][] data = new String[noofRows-1][noOfColoumn];
		for(int i = 0; i < noofRows-1 ; i++)
		{
			for(int j= 0; j< noOfColoumn; j++) {
				DataFormatter df = new DataFormatter();
				data [i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

}
