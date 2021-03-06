package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.rough.TestLogs;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestBase {
/*
 * WebDriver - Done
 * Properties - Done
 * Logs - Log4J Jar , .log , Log4j.properties - Done
 * ExtentReports - Done
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
	public static Logger log = LogManager.getLogger("Base");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep= ExtentManager.getInstance();
	public static ExtentTest test;
	public static WebDriver driver;
	public static String browser;
	
	//Check Element presence
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
	
	//Click Action on a web element 
	public void click(String locator)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
			
		test.log(LogStatus.INFO, "Clicked on Button : "+ locator);
		
	}

	//Enter text on a web element
	public void typing(String locator, String value)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		
		test.log(LogStatus.INFO, "Typing in : "+ locator +" Entered Text is : "+ value );
		
	}
	
	//Select item from drop down list
	static WebElement dropdown;
	public void select(String  locator, String value)
	{
		if(locator.endsWith("_CSS"))
		{
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}else if(locator.endsWith("_XPATH"))
		{
			
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if(locator.endsWith("_ID"))
		{
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO, "Selecting from dropdown : "+ locator +" Selected Value is : "+ value );
	}
	
	//Function for Soft assertion to continue executing rest of TCs and steps
	public static void verifyEquals(String actual,String expected) throws IOException 
	{
		try 
		{
			Assert.assertEquals(actual, expected);
			
		}
		catch(Throwable e)
		{
			TestUtil.captureScreenshot();
			//ReportNG
			Reporter.log("<br>");
			Reporter.log("Verification failure : "+ e.getMessage());
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src=\""+TestUtil.screenshotName+"\" height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			//ExtentReport
			test.log(LogStatus.FAIL," Verification failure with exception : " + e.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
		}
	}

	//Load configuration Config.properties and OR.properties and open selected browser 
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
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty())
		{
			browser = System.getenv("browser");
			
		}
		else
		{
			browser = config.getProperty("browser");
		}
		config.setProperty("browser", browser);
		if(config.getProperty("browser").equals("firefox")) 
		{
			//System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver= new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver= new ChromeDriver();
			log.debug("Chrome Launched!!");
		}
		else if(config.getProperty("browser").equals("IE")) 
		{
			//System.setProperty("webdriver.IE.driver", "IE.exe");
			driver= new InternetExplorerDriver();
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to :"+ config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.wait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,5);
	}
	
	//Close browser session
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
