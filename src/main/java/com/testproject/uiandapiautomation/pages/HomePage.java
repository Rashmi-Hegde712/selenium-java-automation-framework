package com.testproject.uiandapiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.testproject.uiandapiautomation.UIbase.uiBasePage;
import com.testproject.uiandapiautomation.utils.BrowserUtils;

public class HomePage extends uiBasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Big page with many elements']")
	private WebElement badgeWithElements;
	
	@FindBy(css= "span#Section_of_Buttons")
	private WebElement btnsPage;
	
	public void clickOnBadgeWithElements()
	{
		BrowserUtils.Click(badgeWithElements, driver);		
	}
		
	public String fetchBtnsPageString() 
	{
		BrowserUtils.waitForVisible(btnsPage, driver);
		String btnsStr = btnsPage.getText();
		return btnsStr;
	}	
	
}