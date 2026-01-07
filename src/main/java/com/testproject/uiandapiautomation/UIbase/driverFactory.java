package com.testproject.uiandapiautomation.UIbase;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.testproject.uiandapiautomation.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static WebDriver initializeDriver() {		
		
		String browser = ConfigFileReader.get("browser").toLowerCase();
		switch (browser) {
			case "chrome":
				ChromeOptions coptions = new ChromeOptions();
				coptions.addArguments("--disable-notifications");
				coptions.addArguments("--headless=new");
				coptions.addArguments("--window-size=1920,1080"); // important!
				 
				WebDriverManager.chromedriver().clearDriverCache().setup();			
				WebDriverManager.chromedriver().setup();
				WebDriver chDriver = new ChromeDriver(coptions);
				chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				tlDriver.set(chDriver); 				 		
				getDriver().manage().window().setSize(new Dimension(1920, 1080));
				break;
			case "firefox":
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addPreference("dom.webnotifications.enabled", false); 
				foptions.addArguments("--headless");
				foptions.addArguments("--width=1920");
				foptions.addArguments("--height=1080");
				WebDriverManager.firefoxdriver().clearDriverCache().setup();
				WebDriverManager.firefoxdriver().setup();
				WebDriver fDriver = new FirefoxDriver(foptions);
				fDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				tlDriver.set(fDriver);
				getDriver().manage().window().setSize(new Dimension(1920, 1080));
				break;
			default:
				throw new RuntimeException("Unsupported Browser: "+browser);
		}
		
		return getDriver();
	}

	
	  public static WebDriver getDriver() { 
		  return tlDriver.get(); 
		  }
	 
	
	public static void quitDriver() {
		
		  if(tlDriver.get()!=null) { 
			  tlDriver.get().manage().deleteAllCookies();
			  tlDriver.get().quit(); 
			  tlDriver.remove(); 
		  }		 
	}
	
}
