package com.automation.RealtimeProject.MyCompany.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.RealtimeProject.MyCompany.helper.logger.LoggerHelper;

public class javascriptHelper 
{
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(javascriptHelper.class);
	
	public javascriptHelper(WebDriver driver) 
	{
		
		this.driver = driver;
		
	}
	
	
}
