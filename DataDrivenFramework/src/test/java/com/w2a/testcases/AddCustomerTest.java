package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase{

	@Test(dataProviderClass=TestUtil.class,dataProvider = "dp")
	public void AddCustomerTest(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException
	{
		
		//driver.findElement(By.cssSelector(OR.getProperty("AddCustbtn_css"))).click();
		//driver.findElement(By.cssSelector(OR.getProperty("firstName_css"))).sendKeys(firstName);
		//driver.findElement(By.cssSelector(OR.getProperty("lastName_css"))).sendKeys(lastName);
		//driver.findElement(By.cssSelector(OR.getProperty("postCode_css"))).sendKeys(postCode);
		//driver.findElement(By.cssSelector(OR.getProperty("AddCustSubmitBtn_css"))).click();
		click("AddCustbtn_CSS");
		typing("firstName_CSS", firstName);
		typing("lastName_CSS", lastName);
		typing("postCode_CSS", postCode);
		click("AddCustSubmitBtn_CSS");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		//Assert.fail(" Test Failed Intentially ");
		Thread.sleep(3000);
	}

}
