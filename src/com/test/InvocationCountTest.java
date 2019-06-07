package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	
	//InvocationCOunt--- Is used to run(execute) the same @test more number of times
	
	@Test(invocationCount = 10)
	public void sum() {
		
		int a=10;
		int b=20;
		int sum= a+b;
		System.out.println("Sum= "+sum);
	}

}
