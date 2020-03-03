package com.w2a.rough;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG 
{
	@BeforeMethod //Will run befoe each method in this class
	public void beforeMethood() 
	{
		System.out.println("Before Method");
	}
	
	@BeforeTest  //will run one time only
	public void before() 
	{
		System.out.println("Before Test");
	}
	
	@Test(priority=1)
	public void test1()
	{
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(1,2);
		soft.assertEquals(true,false);
		soft.assertAll();
		
	}
	

}
