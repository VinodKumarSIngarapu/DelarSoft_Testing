package com.delarSoft;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.IReporter;

import com.Framework.BaseTest;
import com.dataProviders.ExcelReader;

public class DelarSoftHomePage extends BaseTest{

	WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public DelarSoftHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reader.ReadData();
	}
	
	
	@FindBy (xpath="//a[@class='blockbestsellers']")
	public WebElement bestSellers;
	
	@FindBy (xpath="//div[@class='left-block']")
	public WebElement leftBlock;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Printed Chiffon Dress']")
	public WebElement pcdTitle;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Printed Chiffon Dress']//img")
//	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Printed Chiffon Dress']//following-sibling::a")
	public WebElement pcdquickViewImg;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Printed Chiffon Dress']//following-sibling::a")
	public WebElement pcdquickView;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Blouse']")
	public WebElement blouseTitle;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Blouse']//img")
	public WebElement blousequickViewImg;
	
	@FindBy (xpath="//*[@id='blockbestsellers']//div[@class='left-block']//a[@title='Blouse']//following-sibling::a")
	public WebElement blousequickView;
	
	
	public void loadBestSeller() {
		
		if(bestSellers != null) {
			if(bestSellers.isDisplayed() && bestSellers.isEnabled() && bestSellers.getText().trim().equalsIgnoreCase(reader.getHomePageTabs())) {
				bestSellers.click();
				Assert.assertTrue(true, "Best seller button is displayed and able to click");
			}else {
				Assert.assertFalse(false, "Best seller button is not displayed and unable to click");
			}
		}
	}
	
	public void loadNegativeScenario() throws InterruptedException, IOException {
		if(bestSellers != null) {
			if(bestSellers.isDisplayed() && bestSellers.isEnabled() && bestSellers.getText().trim().equalsIgnoreCase(reader.getNegativeScenarioTab())) {
				bestSellers.click();
				Assert.assertTrue(true, "Best seller button is displayed and able to click");
			}else {
				Assert.assertFalse(false, "Best seller button is not displayed and unable to click");
				
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File destFile = new File("C:\\Users\\Yashmit\\Interview-eclipse-workspace\\DelarSoft_Test\\screenshots\\Failed.png");
				FileUtils.copyFile(SrcFile, destFile);
			}
		}
	}
	
	public void loadPrintedChiffonDress() throws InterruptedException{
//		getWebDriverWait().until(ExpectedConditions.visibilityOf(pcdquickView));
		if(pcdquickViewImg != null) {
			if(pcdquickViewImg.isDisplayed() && pcdquickViewImg.isEnabled() && pcdTitle.getAttribute("title").trim().equalsIgnoreCase(reader.getScenario1())) {
				Actions act = new Actions(driver);
				act.moveToElement(pcdquickViewImg);
				
				Thread.sleep(2000);
				act.moveToElement(pcdquickViewImg);
				
				act.moveToElement(pcdquickView);
				act.click().build().perform();
				
//				act.click();
//				pcdquickView.click();
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", pcdquickView);

				Assert.assertTrue(true, "Quick view button is displayed and able to click");
			}else {
				Assert.assertFalse(false, "Quick view button is not displayed and unable to click");
			}
		}
	}
	
	public void loadBlouseDress() throws InterruptedException{
//		getWebDriverWait().until(ExpectedConditions.visibilityOf(blousequickViewImg));
		if(blousequickViewImg != null) {
			if(blousequickViewImg.isDisplayed() && blousequickViewImg.isEnabled() && blouseTitle.getAttribute("title").trim().equalsIgnoreCase(reader.getScenario2())) {

				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", blousequickView);

				Assert.assertTrue(true, "Blouse Quick view button is displayed and able to click");
			}else {
				Assert.assertFalse(false, "Blouse Quick view button is not displayed and unable to click");
			}
		}
	}
}
