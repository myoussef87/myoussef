package com.w2a.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	
	@Test
	public void loginBankManager() throws InterruptedException, IOException
	{
		
		//verifyEquals("xyz", "abc");
		Thread.sleep(3000);
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.debug("LoginBankManager TC");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlbtn_css"))).click();
		click("bmlbtn_CSS");
		Thread.sleep(1000);
		log.debug("Login Succeded");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCustbtn_CSS"))),"Login Not Successful");
		Reporter.log("Login Succeded TestNG");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\m.yousaf\\Pictures\\2019-12-15_1650.png\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\m.yousaf\\Pictures\\2019-12-15_1650.png\"><img src=\"C:\\Users\\m.yousaf\\Pictures\\2019-12-15_1650.png\" height=200 width=200></img></a>");
		//Assert.fail("Test Failed Intentially");
	}

}
