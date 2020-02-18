package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotPath;
	public static String screenshotName;
	
	static public void captureScreenshot() throws IOException
	{
		Date d= new Date();
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+ screenshotName ));
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) //will take method name and pass it in this method getName();
	{
		String sheetName= m.getName();
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
	
	public static boolean isTestRunnable(String testName,ExcelReader excel)
	{
		String sheetName= "test_suite";
		int rows = excel.getRowCount(sheetName);
		for(int rowNum =2 ;rowNum<=rows;rowNum++)
		{
			String testCase=excel.getCellData(sheetName, "TCID", rowNum);
			if(testCase.equalsIgnoreCase(testName))
			{
				String runmode=excel.getCellData(sheetName, "runmode", rowNum);
				if(runmode.equalsIgnoreCase("Y"))
				{
					return true;
				
				}else 
				{
					return false;
				}
				
			}
		}
		return false;
		
	}

}
