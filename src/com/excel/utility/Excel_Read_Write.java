package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_Write {
	
	public File file;
	public FileInputStream fis= null;
	public FileOutputStream fos= null;
	public DataFormatter formatData= null;
	private XSSFWorkbook wb= null;
	private XSSFCell cell = null;
	private XSSFSheet sheet= null;
	
	
	
/************* Reads data from excel sheet using path, sheetname, columnname and rowno  *********/
	
	public String  ExcelRead1(String path, String sheetname, String columnname, int rowno) {
		
		String mainValue= "";
		
		file= new File(path);
		
		try {
			fis= new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			wb= new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		XSSFRow headerRow = sheet.getRow(0);
		short columnCount = headerRow.getLastCellNum();
		
		for(int i=0;i<=columnCount; i++) {
			
			XSSFCell headerColCell = headerRow.getCell(i);
			
			String headerColValue = headerColCell.getStringCellValue();
			if(headerColValue.equals(columnname)) {
				
				XSSFRow mainRow = sheet.getRow(rowno);
				XSSFCell mainCell = mainRow.getCell(i);
				
				//mainValue = formatData.formatCellValue(mainCell);
				System.out.println(mainCell.getCellType());
				
				
				switch(mainCell.getCellType())
                {
                case Cell.CELL_TYPE_STRING:
                	mainValue= mainCell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                	mainValue= String.valueOf(mainCell.getNumericCellValue());
                	System.out.println(mainValue);
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                	mainValue= String.valueOf(mainCell.getBooleanCellValue());
                    break;
				default:
					break;
                }
				//mainValue = mainCell.getStringCellValue();
				break;
			}
			
		}
		return mainValue;
		
	}
	
	
	
	
	/************* writes data into a cell in  excel sheet using path, sheetname, columnname and rowno  *********/

	public boolean writeExcelCell(String path, String sheetname, String columnname, int rownum, String data) {
		
		try {
			
			 file = new File(path);
			 fis= new FileInputStream(file);
			 wb= new XSSFWorkbook(fis);
			 XSSFSheet sheet = wb.getSheet(sheetname);
			 
			 XSSFRow headerRow = sheet.getRow(0);
			 short columnCount = headerRow.getLastCellNum();
			 for(int i=0; i<=columnCount; i++) {
				 XSSFCell headerCell = headerRow.getCell(i);
				 String headerCellValue = headerCell.getStringCellValue();
				 
				 if(headerCellValue.trim().equals(columnname)) {
					 
					 XSSFRow writeRow = sheet.getRow(rownum);
					 XSSFCell writeCell = writeRow.getCell(i);
					 
					 if(writeCell == null) {
						 writeCell = writeRow.createCell(i);
						 
					 }
					 writeCell.setCellValue(data);
					 break;
				 }
			 }
			 
			 fis.close();
			 
			 fos= new FileOutputStream(path);
			 wb.write(fos);
			 fos.close();
			 
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	/************* Return the row count in index form (4 rows(with header)----> Count=3 *********/	
	
	public int getRowCount(String Path,String sheetName) {
		
		int rowCount;
		try {
			file= new File(Path);
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		rowCount = sheet.getLastRowNum();
		return rowCount;
	
	}
	
	
	
	/************* Adds the sheet to the excel file and return true or false *********/
	
	public boolean addSheetToExcel(String path,String newSheetname) {

		try {
			file = new File(path);
			fos= new FileOutputStream(file);
			wb.createSheet(newSheetname);
			wb.write(fos);
			fos.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	
}
