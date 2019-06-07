package com.datadriven.test;

import com.excel.utility.Excel_Read_Write;
import com.excel.utility.Xls_Reader1;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader1 rw= new Xls_Reader1("C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\RegExcel.xlsx");
		

		//To add the sheet in the excel
		if(!rw.isSheetExist("HomePage")) {
			rw.addSheet("HomePage");
		}
		
		
		//to find the column count
		int columnCount = rw.getColumnCount("RegTestData");
		System.out.println(columnCount);
		
		
		int cellRowNum = rw.getCellRowNum("RegTestData", "Firstname", "Tom");
		System.out.println(cellRowNum);
	}
	
	
	
	
	
	
	

}
