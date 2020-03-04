package com.w2a.rough;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG 
{
	@BeforeMethod //Will run before each method in this class
	public void beforeMethood() 
	{
		System.out.println("Before Method");
	}
	
	@BeforeTest  //will run one time only
	public void before() 
	{
		System.out.println("Before Test");
	}
	
	@Test(priority=2,groups="Youssef")
	public void test2()
	{
		SoftAssert soft=new SoftAssert(); //using it to continue executing all failed assertions
		soft.assertEquals(1,2);
		soft.assertEquals(true,false);
		soft.assertAll();///Used to make the Test Fail and report all failed assertions
		
	}
	@Test(priority=1,dependsOnMethods = { "test2" },alwaysRun=true,groups="Youssef2")//it depends on test2 and add Always run = true to continue even the dependency is failed https://testng.org/doc/documentation-main.html#dependencies-with-annotations
	public void test1()
	{
		SoftAssert soft=new SoftAssert(); //using it to continue executing all failed assertions
		soft.assertEquals(1,2);
		soft.assertEquals(true,false);
		soft.assertAll();///Used to make the Test Fail and report all failed assertions
		
	}
	

}
