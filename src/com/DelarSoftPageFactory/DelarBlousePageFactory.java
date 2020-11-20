package com.DelarSoftPageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.BaseTest;
import com.dataProviders.ConfigFileReader;
import com.delarSoft.BlousePage;
import com.delarSoft.DelarSoftHomePage;


public class DelarBlousePageFactory extends BaseTest{
	
	WebDriver driver;
	
	DelarSoftHomePage homePage;
	BlousePage bp;
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	public DelarBlousePageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void scenario2() throws InterruptedException, IOException{
		String baseUrl = configFileReader.getApplicationUrl();
		getDriver().get(baseUrl);
		getDriver().manage().window().maximize();
		
		loadBlousePage();
		System.out.println("Test2 completed...");	
	}
		
	
	
	public void loadBlousePage() throws InterruptedException, IOException{
		homePage = new DelarSoftHomePage(getDriver());
		bp = new BlousePage(getDriver());
		
		homePage.loadBestSeller();

		homePage.loadBlouseDress();
		
		bp.verifyContent();
		
		bp.addToCart();

		bp.verifyCart();
		
	}
	
	
}
