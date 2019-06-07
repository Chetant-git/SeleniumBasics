package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loginTest() {
		System.out.println("Login test");
		//int i= 9/0;
	}
	
	
	//1 test case depends on other test case use dependsOnMethods
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest() {
		System.out.println("HomePage test is totally dependend on logintest");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void SearchPageTest() {
		System.out.println("SearchPage test is totally dependend on logintest");
	}
	
	
	@Test(dependsOnMethods = "loginTest")
	public void RegistrationPageTest() {
		System.out.println("Registration page test is totally dependend on logintest");
	}
}
