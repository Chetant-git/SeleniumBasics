package com.datadriven.test;

import org.apache.poi.xssf.usermodel.XSSFCell;

import com.excel.utility.Excel_Read_Write;

public class DataDrivenTest {

	
	public static void main(String[] args) {
		
		
		Excel_Read_Write rw= new Excel_Read_Write();
		
		String path= "C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\RegExcel.xlsx";
		
		String excelRead = rw.ExcelRead1(path, "RegTestData", "Firstname", 1);
		
		System.out.println("Excel read Value: "+excelRead);
		
		boolean writeExcel = rw.writeExcelCell(path, "RegTestData", "status", 1, "Pass");
		System.out.println("Write status: "+writeExcel);
		
	}
	
}
