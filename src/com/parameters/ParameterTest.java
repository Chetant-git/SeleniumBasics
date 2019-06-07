package com.parameters;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterTest {

	WebDriver driver;
	
	/*
	 * @BeforeMethod
	 * 
	 * @Parameters({"browser"}) public void browserSetup(String browser) {
	 * if(browser.equals("chrome")){ System.setProperty("webdriver.chrome.driver",
	 * "D:\\Drivers\\chromedriver.exe"); driver= new ChromeDriver(); }else
	 * if(browser.equals("Firefox")) { System.setProperty("webdriver.gecko.driver",
	 * "D:\\Drivers\\geckodriver.exe"); driver= new ChromeDriver(); }
	 * 
	 * }
	 */
	
	
	@Test
	@Parameters({"browser","url","username","password"})
	public void CRMloginTest(String browser, String url, String username, String password) {
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();	
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
			driver= new ChromeDriver();	
		}
		
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='password' and @value='Login']")).click();
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		
	}
}
