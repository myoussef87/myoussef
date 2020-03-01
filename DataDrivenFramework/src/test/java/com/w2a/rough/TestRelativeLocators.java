package com.w2a.rough;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators {
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.way2automation.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("m.youssef@aptc4i.com");;
		//driver.findElement(By.xpath("//*[@id=\"load_form\"]/div/div[2]/input")).click();;
		driver.findElement(withTagName("input").toRightOf(By.linkText("Signin"))).click();
		//driver.findElement(withTagName("input").below(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input"))).click();
		// Relative Xpath You can search with $x("//form[@class='ajaxsubmit']/div/div/input[@type='submit']") 
		// $x("//form[@class='ajaxsubmit']/div/div/input[@type='submit']") 
		// $x("//tagName[text() ,'value']") e.g. $x("//input[text() ,'XYZ']") 
		// $x("//*[contains(text() ,'Signin')]") e.g. $x("//input[contains(text() ,'XYZ')]")
		// $x("//*[contains(@attribute ,'value')]") e.g. $x("//*[contains(@type ,'text')]")
		// $x("//tagName[starts-with(@attribute ,'value')]")
		// $x("//tagName[starts-with(@attribute ,'value')]/..") or $x("//tagName[starts-with(@attribute ,'value')]/parent::tagName") - find Parent element  
		// 
		// $x("//tagName[starts-with(@attribute ,'value')]/following-sibling::tagName") --- to find following siblings
		// $x("//tagName[starts-with(@attribute ,'value')]/preceding-sibling::tagName") --- to find preceding siblings
		// index   $x("//form[@class='ajaxsubmit']/div/div/input[@type='submit'][1]") 
		
		
        ////CSS Selectors///
		// Normal -> $$("input[id='identifierid']")
		// Concat -> $$("input[id='identifierid'][type='email']")
		// starts with -> $$("input[id^='identifierid']")
		// Ends with -> $$("input[id$='identifierid']")
		// contains with -> $$("input[id*='identifierid']")
		// with id -> $$("#identifierid")
		// with id and tag -> $$("input#identifierid")
		// with Class -> $$("div.ClassName")
		// with Child -> $$("div.ClassName > div > div:first-child") $$("div.ClassName > div > div:last-child") $$("div.ClassName > div > div:nth-child(2)")
		
		
	} 

}
