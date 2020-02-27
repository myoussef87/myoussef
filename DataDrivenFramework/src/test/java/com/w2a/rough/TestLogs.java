package com.w2a.rough;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLogs {
	
	
	public static Logger log = LogManager.getLogger("Base");

	public static void main(String[] args) {
		
		Date d = new Date();
		
		System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		log.error("Test Error");
	}

}
