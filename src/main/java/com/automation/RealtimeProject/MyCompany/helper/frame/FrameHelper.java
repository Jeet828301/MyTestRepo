package com.automation.RealtimeProject.MyCompany.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.RealtimeProject.MyCompany.helper.logger.LoggerHelper;

public class FrameHelper 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	/*Switched to frame at an index*/
	public void switchToFrameByIndex(int index)
	{
		log.info("Switching to frame at index ="+index);
		driver.switchTo().frame(index);
		log.info("Present in frame at "+index);
	}
	
	/*Switched to frame by name*/
	public void switchToFrameByName(String name)
	{
		log.info("Switching to frame by name ="+name);
		driver.switchTo().frame(name);
		log.info("Present in frame by name "+name);
	}
	
	/*Switched to frame by element identification*/
	public void switchToFrameByElement(WebElement element)
	{
		log.info("Switching to frame by element");
		driver.switchTo().frame(element);
		
	}
}
