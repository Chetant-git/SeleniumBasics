package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader1;

public class TestUtil {

	static Xls_Reader1 reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]>myData= new ArrayList<Object[]>();
		
		try {
			reader= new Xls_Reader1("C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\RegExcel.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int rowCount = reader.getRowCount("RegTestData");
		for(int i=2; i<=rowCount; i++) {
			
			String firstname = reader.getCellData("RegTestData", "Firstname", i);
			String lastname = reader.getCellData("RegTestData", "Lastname", i);
			String Email = reader.getCellData("RegTestData", "Email", i);
			String phoneno = reader.getCellData("RegTestData", "phoneno", i);
			String address = reader.getCellData("RegTestData", "address", i);
			String city = reader.getCellData("RegTestData", "city", i);
			String state = reader.getCellData("RegTestData", "state", i);
			String zipcode = reader.getCellData("RegTestData", "zipcode", i);
			
			Object ob[]= {firstname,lastname,Email,phoneno,address,city,state,zipcode};
			myData.add(ob);
		}
		
		return myData;
		
	}
}
