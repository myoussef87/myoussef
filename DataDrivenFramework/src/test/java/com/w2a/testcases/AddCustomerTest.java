package com.w2a.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase{

	@Test(dataProviderClass=TestUtil.class,dataProvider = "dp")
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException //No need to pass each column in method as we just pass a hashtable from dataprovider
	{
		
		//driver.findElement(By.cssSelector(OR.getProperty("AddCustbtn_css"))).click();
		//driver.findElement(By.cssSelector(OR.getProperty("firstName_css"))).sendKeys(firstName);
		//driver.findElement(By.cssSelector(OR.getProperty("lastName_css"))).sendKeys(lastName);
		//driver.findElement(By.cssSelector(OR.getProperty("postCode_css"))).sendKeys(postCode);
		//driver.findElement(By.cssSelector(OR.getProperty("AddCustSubmitBtn_css"))).click();
		if(!data.get("runmode").equalsIgnoreCase("Y"))
		{
			test.log(LogStatus.SKIP, " Skipped As Run Mode is N ");
			rep.endTest(test);
			rep.flush();
			throw new SkipException("Skip Test Case as run mode is set to N");
					
		}
		click("AddCustbtn_CSS");
		typing("firstName_CSS", data.get("firstName"));
		typing("lastName_CSS", data.get("lastName"));
		typing("postCode_CSS", data.get("postCode"));
		click("AddCustSubmitBtn_CSS");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		//Assert.fail(" Test Failed Intentially ");
		Thread.sleep(3000);
	}

}
