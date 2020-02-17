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
	public void OpenAccountTest(String customer, String currency) throws InterruptedException
	{
		
		
	}
	
}
