package com.testproject.uiandapiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testproject.uiandapiautomation.UIbase.uiBasePage;
import com.testproject.uiandapiautomation.utils.BrowserUtils;

public class FillOutFormsPage extends uiBasePage {
    
    public FillOutFormsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//a[text()='Fill out forms']")
    private WebElement formLink;
    
    @FindBy(css = "#et_pb_contact_name_0")
    private WebElement name;
    
    @FindBy(css = "textarea#et_pb_contact_message_0")
    private WebElement textArea;
    
    @FindBy(xpath="//div[@class='et_pb_column et_pb_column_1_2 et_pb_column_1  et_pb_css_mix_blend_mode_passthrough']/descendant::button")
    private WebElement submitBtn;

    @FindBy(xpath = "//p[text()='Thanks for contacting us']")
    private WebElement confirmMsg;
    
    public void clickOnFormLink() {
    	BrowserUtils.Click(formLink, driver);
    }
    
    public void enterName(String str) {
        name.clear();
        name.sendKeys(str);
    }
    
    public void enterText(String text) {
    	textArea.clear();
    	textArea.sendKeys(text);
    }

    public void submit() {
    	BrowserUtils.Click(submitBtn, driver);
    }
    
    public String confirmSubmission() {
    	String msg = confirmMsg.getText();
    	return msg;
    }
}
