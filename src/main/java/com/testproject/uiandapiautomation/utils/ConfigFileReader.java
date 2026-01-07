package com.testproject.uiandapiautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 private static Properties prop;
	 
	 static {
		 try {
			 String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
			 FileInputStream fis = new FileInputStream(filePath);
			 prop = new Properties();
			 prop.load(fis);
		 } catch(IOException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Failed to load config.properties");
		 }		 
	 }
	 
	 
	 
 public static String get(String key) {
	 return prop.getProperty(key);
 }	
 
 
}