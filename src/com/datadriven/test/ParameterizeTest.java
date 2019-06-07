package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Excel_Read_Write;

public class ParameterizeTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("https://www.seleniumeasy.com/test/input-form-demo.html");
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		Excel_Read_Write rw= new Excel_Read_Write();
		String path= "C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\RegExcel1.xlsx";
		
		int rowCount = rw.getRowCount(path, "RegTestData");
		
		System.out.println(rowCount);
		
		//parameterization
		for(int i=1; i<=rowCount;i++) {
			
			String firstname = rw.ExcelRead1(path, "RegTestData", "Firstname", i);
			System.out.println("Firstname: "+firstname);
			
			String lastname = rw.ExcelRead1(path, "RegTestData", "Lastname", i);
			System.out.println("lastname: "+lastname);
			
			String Email = rw.ExcelRead1(path, "RegTestData", "Email", i);
			System.out.println("Email: "+Email);
			
			String phoneNo = rw.ExcelRead1(path, "RegTestData", "phoneno", i);
			System.out.println("phoneNo: "+phoneNo);
			
			String address = rw.ExcelRead1(path, "RegTestData", "address", i);
			System.out.println("address: "+address);
			
			String city = rw.ExcelRead1(path, "RegTestData", "city", i);
			System.out.println("city: "+city);
			
			String state = rw.ExcelRead1(path, "RegTestData", "state", i);
			System.out.println("state: "+state);
			
			String zipcode = rw.ExcelRead1(path, "RegTestData", "zipcode", i);
			System.out.println("zipcode: "+zipcode);
			
			
			driver.findElement(By.name("first_name")).clear();
			driver.findElement(By.name("first_name")).sendKeys(firstname);
			
			driver.findElement(By.name("last_name")).clear();
			driver.findElement(By.name("last_name")).sendKeys(lastname);
			
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(Email);
			
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys(phoneNo);
			
			driver.findElement(By.name("address")).clear();
			driver.findElement(By.name("address")).sendKeys(address);
			
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys(city);
			
			Select stateDD= new Select(driver.findElement(By.name("state")));
			stateDD.selectByVisibleText(state);
			
			driver.findElement(By.name("zip")).clear();
			driver.findElement(By.name("zip")).sendKeys(zipcode);
			
			rw.writeExcelCell(path, "RegTestData", "status", i, "pass");
		}

	}

}
