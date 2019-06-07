package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Excel_Read_Write;

public class DataDrivenTest1 {

	public static void main(String[] args) {

		
		Excel_Read_Write rw= new Excel_Read_Write();
		
		String path= "C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\RegExcel1.xlsx";
		
		String firstname = rw.ExcelRead1(path, "RegTestData", "Firstname", 1);
		System.out.println("Firstname: "+firstname);
		
		String lastname = rw.ExcelRead1(path, "RegTestData", "Lastname", 1);
		System.out.println("lastname: "+lastname);
		
		String Email = rw.ExcelRead1(path, "RegTestData", "Email", 1);
		System.out.println("Email: "+Email);
		
		String phoneNo = rw.ExcelRead1(path, "RegTestData", "phoneno", 1);
		System.out.println("phoneNo: "+phoneNo);
		
		String address = rw.ExcelRead1(path, "RegTestData", "address", 1);
		System.out.println("address: "+address);
		
		String city = rw.ExcelRead1(path, "RegTestData", "city", 1);
		System.out.println("city: "+city);
		
		String state = rw.ExcelRead1(path, "RegTestData", "state", 1);
		System.out.println("state: "+state);
		
		String zipcode = rw.ExcelRead1(path, "RegTestData", "zipcode", 1);
		System.out.println("zipcode: "+zipcode);
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("https://www.seleniumeasy.com/test/input-form-demo.html");
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("phone")).sendKeys(phoneNo);
		driver.findElement(By.name("address")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		
		Select stateDD= new Select(driver.findElement(By.name("state")));
		stateDD.selectByVisibleText(state);
		driver.findElement(By.name("zip")).sendKeys(zipcode);
		
		
		
		
		
		
	}

}
