package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;
import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	
	@Test
	public void loginBankManager() throws InterruptedException
	{
		log.debug("LoginBankManager TC");
		driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
		Thread.sleep(1000);
		log.debug("Login Succeded");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCustbtn"))),"Login Not Successful");
		//driver.findElement(By.cssSelector(OR.getProperty("AddCustbtn")));
	}

}
