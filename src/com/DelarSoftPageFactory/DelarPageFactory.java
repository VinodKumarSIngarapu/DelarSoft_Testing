package com.DelarSoftPageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Framework.BaseTest;
import com.dataProviders.ConfigFileReader;
import com.delarSoft.DelarSoftHomePage;
import com.delarSoft.PrintedChiffonDressPage;

public class DelarPageFactory extends BaseTest{
	
	WebDriver driver;
	
	DelarSoftHomePage homePage;
	PrintedChiffonDressPage pcp;
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	public DelarPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void scenario1() throws InterruptedException, IOException{
		String baseUrl = configFileReader.getApplicationUrl();

		getDriver().get(baseUrl);
		getDriver().manage().window().maximize();

		System.out.println("Title of the page is:"+getDriver().getTitle());
		
		loadBestSellerPage();
		
		System.out.println("Test1 completed...");	
	}
		
	
	
	public void loadBestSellerPage() throws InterruptedException, IOException{
		homePage = new DelarSoftHomePage(getDriver());
		pcp = new PrintedChiffonDressPage(getDriver());
		homePage.loadNegativeScenario();
		
		homePage.loadBestSeller();

		homePage.loadPrintedChiffonDress();

		pcp.verifyContent();

		pcp.addToCart();

		pcp.verifyCart();
		
		pcp.verifyEmptyCart();
		
		
	}
	
	
}
