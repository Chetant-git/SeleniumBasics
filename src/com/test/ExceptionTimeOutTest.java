package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

	
	/*
	 * @Test(timeOut=2000,expectedExceptions = NumberFormatException.class) public
	 * void InfiniteLoopTest() {
	 * 
	 * int i=1; while(i==1) { System.out.println(i); }
	 * 
	 * 
	 * }
	 */
	
	
	
	
	@Test(expectedExceptions= NumberFormatException.class)
	public void test1() {
		String a= "100A";
		int parseInt = Integer.parseInt(a);
		System.out.println(parseInt);
	}
}
