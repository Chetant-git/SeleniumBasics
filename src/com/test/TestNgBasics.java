package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {

	
	/* Result----
	 
	@BeforeSuite---Setup system properties for chrome
	@BeforeTest---Launch chrome browser
	@BeforeClass---Login method
	@BeforeMethod---Enter url
	@Test----Google logo test
	@AfterMethod---Logout method
	@BeforeMethod---Enter url
	@Test-----google title test
	@AfterMethod---Logout method
	@BeforeMethod---Enter url
	@Test----Search test
	@AfterMethod---Logout method
	@AfterClass----Close browser
	@AfterTest----delete the cookies
	*/
	
	//@Before----Pre-conditions annotations
	@BeforeSuite  //1
	public void setup() {
		System.out.println("@BeforeSuite---Setup system properties for chrome");
		
	}
	
	
	@BeforeTest //2
	public void launchBrowser() {
		System.out.println("@BeforeTest---Launch chrome browser");
	}
	
	
	@BeforeClass  //3
	public void login() {
		System.out.println("@BeforeClass---Login method");
	}
	
	@BeforeMethod  //4
	public void enterUrl() {
		System.out.println("@BeforeMethod---Enter url");
	}
	
	
	/* @BeforeMethod
	 * @Test  -1
	 * @AfterMethod
	 * 
	 * 
	 * @BeforeMethod
	 * @Test   -2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test   -3
	 * @AfterMethod
	 */
	
	
	//Testcase --- starting with @Test
	@Test  //5
	public void googleTitleTest() {
		System.out.println("@Test-----google title test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("@Test----Search test");
	}
	
	@Test
	public void googleLogo() {
		System.out.println("@Test----Google logo test");
	}
	
	//@After---Post conditions after the test
	@AfterMethod  //6
	public void logout() {
		System.out.println("@AfterMethod---Logout method");
	}
	
	
	@AfterClass  //7
	public void closeBrowser() {
		System.out.println("@AfterClass----Close browser");
	}
	
	
	@AfterTest  //8
	public void deleteAllCookies() {
		System.out.println("@AfterTest----delete the cookies");
	}
	

	
	/*
	 * @AfterSuite public void generateTestReport() {
	 * System.out.println("Generate test report"); }
	 */
}
