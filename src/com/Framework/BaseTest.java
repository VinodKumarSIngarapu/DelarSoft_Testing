package com.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.dataProviders.ConfigFileReader;

public class BaseTest {

	ConfigFileReader configReader = new ConfigFileReader();
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception{
		
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver(browser);
		driver.set(browserFactory.getDriver());
	}
	
    public WebDriver getDriver() {
        return driver.get();
    }
    
    @AfterMethod
    public void afterSetUp() {
    	getDriver().quit();
    }
    
    public WebDriverWait getWebDriverWait() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver.get(),30);
    	return wait;
    }
}
