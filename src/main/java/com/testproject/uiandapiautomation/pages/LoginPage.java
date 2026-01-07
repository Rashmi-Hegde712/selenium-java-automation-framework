package com.testproject.uiandapiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.testproject.uiandapiautomation.UIbase.uiBasePage;
import com.testproject.uiandapiautomation.utils.BrowserUtils;
import com.testproject.uiandapiautomation.utils.ConfigFileReader;
import com.testproject.uiandapiautomation.utils.EncryptionUtil;

public class LoginPage extends uiBasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[contains(text(), 'Login automation')]")
	private WebElement loginLink;
	
	@FindBy(xpath = "//h2[contains(text(), 'Welcome')]")
	private WebElement welcome;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@id='user[remember_me]']")
	private WebElement remembrMe;
	
	@FindBy(css= "button[type='submit']")	
	private WebElement signIn;
	
	@FindBy(xpath="//span[text()='Automation Practice']")
	private WebElement title;
	
	@FindBy(xpath="//h2[contains(text(), 'Products')]")
	private WebElement products;
	
	public void clickOnLoginLink()
	{
		click(loginLink);
	}
	
	public String verifyLogin() {
		String str = welcome.getText();
		return str;
	}
			
	public LoginPage enterEmail()
	{
		enterText(email, ConfigFileReader.get("ui.userName"));
        return this;
	}
	
	public LoginPage enterPassword() throws Exception {
		String encryptedPwd = ConfigFileReader.get("ui.password");
		String password = EncryptionUtil.decrypt(encryptedPwd);
		enterText(pwd, password);
        return this;
    }
	
	public void remembrMeChkBox() {
		click(remembrMe);
	}
	
	public void clickSignIn() {
		click(signIn);
	}
	
	public String verifyProductsPage() {
		BrowserUtils.waitForVisible(products, driver);
		String str = products.getText();
		return str;
	}
	
		
}