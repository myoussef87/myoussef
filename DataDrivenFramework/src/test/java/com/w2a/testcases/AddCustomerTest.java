package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException
	{
		driver.findElement(By.cssSelector(OR.getProperty("AddCustbtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("AddCustSubmitBtn"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Assert.fail("Test Failed Intentially");
	}
	@DataProvider
	public Object[][] getData()
	{
		String sheetName= "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int columns= excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][columns];
		
		for (int rowNum =2 ; rowNum <=rows; rowNum++)
		{
			for (int colNum =0 ; colNum < columns; colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			}
			
		}
		
		return data;
	}
}
