package com.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	
		
		WebDriver driver;
		
		//1 //1
		@BeforeMethod
		public void BrowserSetup() {
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
			
		}
		
		
		
		
		
		//2
		@Test(priority=1,groups = "Title")
		public void googleTitleTest() {
			String title = driver.getTitle();
			System.out.println("Title: "+title);
			//Assert- Used for comparision
			
			Assert.assertEquals(title, "Title", "Google title is incorrect");
		}
		
		//2
		@Test(priority=2,groups="Logo")
		public void googleLogoTest() {
			boolean displayed = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
			Assert.assertTrue(displayed);
			//Assert.assertEquals(displayed, true);
		}
		
		//2
		@Test(priority=3,groups="Link")
		public void mailLinkTest() {
			boolean displayed = driver.findElement(By.linkText("Gmail")).isDisplayed();
			Assert.assertEquals(displayed, true);
			
		}
		
		
		@Test(priority=4, groups="test")
		public void test1() {
			System.out.println("test1");
		}
		
		@Test(priority=5,groups="test")
		public void test2() {
			System.out.println("test2");
		}
		
		
		@Test(priority=6,groups="test")
		public void test3() {
			System.out.println("test3");
		}
		
		
		
		
		
		//3 //3  //3
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

	

}
