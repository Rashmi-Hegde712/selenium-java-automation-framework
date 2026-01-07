package com.testproject.uiandapiautomation.UIbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class uiBasePage {

	protected WebDriver driver ;
	protected WebDriverWait wait;
	
	public uiBasePage(WebDriver driver)
	{
		//this.driver = driverFactory.initializeDriver();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	protected void click(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	protected void enterText(WebElement element, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	
	protected String getText(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element)).getText(); 
	}
}
