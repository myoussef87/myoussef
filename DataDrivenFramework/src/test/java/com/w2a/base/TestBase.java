package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import freemarker.core.ReturnInstruction.Return;


public class TestBase {
/*
 * WebDriver - Done
 * Properties - Done
 * Logs - Log4J Jar , .log , Log4j.properties
 * ExtentReports
 * DB
 * Excel
 * Mail
 * ReportNG, ExtentReports
 * Jenkins
 */
	
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fisconfig;
	public static FileInputStream fisor;
	public static Logger log = Logger.getLogger("devpinoyLogger"); 
	public static ExcelReader excel = new ExcelReader(System.getProperty(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx"));
	
	public static WebDriver driver;
	public boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			log.debug("Element Found");
			return true;
		}
		catch(NoSuchElementException e) 
		{
			log.debug("Element Not Found");
		    return false;
		}
	}
	
	@BeforeSuite
	public void setup() throws InterruptedException 
	{
		if(driver==null) 
		{
			
			try {
				fisconfig = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fisconfig);
				log.debug("Config File Loaded!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fisor = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fisor);
				log.debug("OR File Loaded!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(config.getProperty("browser").equals("firefox")) 
		{
			//System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver= new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome Launched!!");
		}
		else if(config.getProperty("browser").equals("IE")) 
		{
			//System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver= new InternetExplorerDriver();
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to :"+ config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.wait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
	public void teardown() 
	{
		if(driver!=null)
		{
		driver.quit();
		log.debug("Test Execution completed");
		}
	}
}
