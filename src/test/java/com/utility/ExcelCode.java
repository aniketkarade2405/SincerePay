package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelCode {
	
	public static String getData(int row, int cell) throws EncryptedDocumentException, IOException {
		String data;
		
		FileInputStream excel = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\sincerpay\\Excel\\Data.xlsx");
		Sheet Inputdata = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		try {
			data = Inputdata.getRow(row).getCell(cell).getStringCellValue();
		}
		catch(Exception e) {
			//upcasting int to long data
			long intdata = (long)Inputdata.getRow(row).getCell(cell).getNumericCellValue();
			//data
			data = " " + intdata;
		}
		return data;
	}
	


}
