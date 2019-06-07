package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class FillFormTest {

	WebDriver driver;
	@BeforeMethod
	public void browserSetup() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
	}
	
	
	
	//Fetches data from excel sheet
	@DataProvider
	public Iterator<Object[]> getRegTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
//Data provider (
//* The sequence of the parameters in excel sheet and in @Test method shoulbe be same
// * All the columns names in excel sheet should be passed in @Test method while using dataprovider
	
	@Test(dataProvider = "getRegTestData")
	public void RegpageTest(String firstname, String lastname, String Email, String phoneNo, String address, String city, String state, String zipcode) {
		
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
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
