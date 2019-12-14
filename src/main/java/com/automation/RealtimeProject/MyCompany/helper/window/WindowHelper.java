package com.automation.RealtimeProject.MyCompany.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.RealtimeProject.MyCompany.helper.logger.LoggerHelper;

public class WindowHelper 
{
	private WebDriver driver;
	private Logger log= LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	/*switching to main window*/
	public void switchToParentWindow()
	{
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
		log.info("Switched to parent window");
	}
	
	/*Switching to child window/tab at an index*/
	public void switchToChildAtIndex(int index)
	{
		log.info("Fetching the details of all the openend tabs");
		Set<String> windows=driver.getWindowHandles();
		int i=1;
		for(String window:windows)
		{
			log.info("Switched to child window at index "+index);
			if(i==index)
			{
				log.info("Within child window");
				driver.switchTo().window(window);
			}
			else
			{
				i++;
			}
		}
		
	}
	
	/*closing all windows/tabs and switching back to parent*/
	public void closeAllTabsSwitchToParent()
	{
		log.info("Getting details of parent and child windows");
		String parentWindow=driver.getWindowHandle();
		log.info("Parent window id ="+parentWindow);
		log.info("Now getting id's of all child windows/tabs");
		Set<String> windows=driver.getWindowHandles();
		
		for(String window:windows)
		{

			if(!window.equalsIgnoreCase(parentWindow))
			{
				log.info("Closing child window/tab with ID ="+window);
				driver.close();
			}
		}
		log.info("Switched to parent window");
		driver.switchTo().window(parentWindow);
	}
	
	
	/*To navigate back*/
	public void navigateBack()
	{
		log.info("navigating back");
		driver.navigate().back();
	}
	
	/*To navigate forward*/
	
	public void navigateForward()
	{
		log.info("Navigating forward");
		driver.navigate().forward();
	}
}
