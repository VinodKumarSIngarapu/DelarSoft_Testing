package com.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.dataProviders.ConfigFileReader;

public class BrowserFactory {
	 
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	 ConfigFileReader configReader;
	
	private BrowserFactory() {
		
	}
	
	public static BrowserFactory getInstance() {
		if(instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}
	
	public final void setDriver(String browser) throws Exception{
		configReader = new ConfigFileReader();
		 switch (browser) {
			 case "firefox":
				 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yashmit\\Vinod\\Testing_Browsers_Drivers\\geckodriver.exe");
				 webDriver.set(new FirefoxDriver());
			 break;
			 case "ie":
				 System.setProperty("webdriver.ie.driver", "C:\\Users\\Yashmit\\Vinod\\Testing_Browsers_Drivers\\IEDriverServer.exe");
				 webDriver.set(new InternetExplorerDriver());
			 break;
			 case "chrome":
				 System.setProperty("webdriver.chrome.driver", configReader.getDriverPath("chrome"));
				 webDriver.set(new ChromeDriver());
			 break;
		 }
	}
	
	public WebDriver getDriver() {
		return webDriver.get();
	}	 
	 
}
