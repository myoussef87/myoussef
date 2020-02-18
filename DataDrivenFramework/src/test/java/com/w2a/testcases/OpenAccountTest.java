package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase{

	@Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException
	{
		click("OpenAccount_CSS");
		select("Customer_CSS", customer);
		select("Currency_CSS", currency);
		click("ProcessSubmitBtn_CSS");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
	}
	
}
