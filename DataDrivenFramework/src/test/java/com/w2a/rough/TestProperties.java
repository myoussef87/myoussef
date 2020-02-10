package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		Properties config=new Properties();
		Properties OR=new Properties();
		FileInputStream fisconfig=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		FileInputStream fisor=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		config.load(fisconfig);
		OR.load(fisor);
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlbtn"));
				
	}

}
