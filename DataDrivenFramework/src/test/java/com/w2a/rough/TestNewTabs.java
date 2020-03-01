package com.w2a.rough;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNewTabs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		System.out.println("First Window Title :"+ driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://gmail.com");
		System.out.println("Second Window Title :"+ driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[3]/a[1]")).click();
		Set<String> s =driver.getWindowHandles();
		Iterator<String> i=s.iterator();
		i.next();
		i.next();
		String Third_window=i.next();
		driver.switchTo().window(Third_window);
		System.out.println("Third Window Title :"+ driver.getTitle());
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://microsoft.com");
		System.out.println("Fourth Window Title :"+ driver.getTitle());
		driver.close();
		driver.switchTo().window(Third_window);
		driver.close();
	}

}
