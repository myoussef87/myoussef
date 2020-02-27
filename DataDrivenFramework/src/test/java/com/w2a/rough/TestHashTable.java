package com.w2a.rough;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class TestHashTable extends TestBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	@Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException //No need to pass each column in method as we just pass a hashtable from dataprovider
	{
		click("OpenAccount_CSS");
		select("Customer_CSS", data.get("customer"));
		select("Currency_CSS", data.get("currency"));
		click("ProcessSubmitBtn_CSS");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
	}
	@DataProvider(name="dp")
	public Object[][] getData(Method m) //will take method name and pass it in this method getName();
	{
		String sheetName= m.getName();
		int rows = excel.getRowCount(sheetName);
		int columns= excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][1];
		
		
		//Creating a Hashtable per each row with key is first row and value changes based on rows
		Hashtable<String, String> table=null;
		
		for (int rowNum =2 ; rowNum <=rows; rowNum++)
		{
			//Create new hashTable per row
			table= new Hashtable<String, String>();
			for (int colNum =0 ; colNum < columns; colNum++)
			{
				
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum)); //set 1st row as a key and set value based on rows 
				System.out.println(table.values().toString());
				data[rowNum-2][0] = table; //set data as hashtable 
				System.out.println(table.values().toString());
			}
			
		}
		
		return data;

}
}
