package com.automation.RealtimeProject.MyCompany.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.RealtimeProject.MyCompany.helper.logger.LoggerHelper;

public class WaitHelper 
{
	private static WebDriver driver;
	
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeout,TimeUnit unit)
	{
		log.info("The implicit time is set to"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		
	}
	
	private WebDriverWait getWait(int timeUnitInSeconds,int pollingTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeUnitInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void waitForElementVisibility(WebElement element,int timeInSeconds,int pollingEveryMiliSecond)
	{
		log.info("Waiting for element"+element.toString()+" for "+timeInSeconds+" seconds");
		WebDriverWait wait=getWait(timeInSeconds,pollingEveryMiliSecond);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}
	
	public void waitForElementToBeClickable(WebElement element,int timeInSeconds,int pollingInMilisecond)
	{
		log.info("Waiting for element "+element.toString()+" for "+timeInSeconds+" seconds");
		WebDriverWait wait=getWait(timeInSeconds,pollingInMilisecond);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
		}
	
	public boolean waitForElementNotPresent(WebElement element,int timeInSeconds,int pollingInMiliSeconds)
	{
		log.info("Waiting for element "+element.toString()+" for "+timeInSeconds+" seconds");
		WebDriverWait wait=getWait(timeInSeconds,pollingInMiliSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is invisible now");
		return status;
		
	}
	
	public void frameToBeVisibleandSwitch(WebElement element,int timeInSeconds, int pollingInMiliSeconds)
	{
		WebDriverWait wait=getWait(timeInSeconds,pollingInMiliSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	
	private Wait<WebDriver> getFluentWait(int timeoutInSeconds,int pollingOutInMillisec)
	{
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingOutInMillisec))
				.ignoring(NoSuchElementException.class);
		return fwait;
				
	}
	
	public WebElement waitForElememnt(WebElement element,int timoutInSeconds,int pollingInMilisec)
	{
		Wait<WebDriver> status = getFluentWait(timoutInSeconds,pollingInMilisec);
		status.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTimeout(long timeoutInseconds,TimeUnit unit)
	{
		log.info("The page load timeout is"+timeoutInseconds);
		driver.manage().timeouts().pageLoadTimeout(timeoutInseconds, unit);
	}
	
}
