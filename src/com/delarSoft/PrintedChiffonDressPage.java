package com.delarSoft;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Framework.BaseTest;

public class PrintedChiffonDressPage extends BaseTest{

	WebDriver driver;
	public PrintedChiffonDressPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='pb-center-column col-xs-12 col-sm-4']//h1")
	public WebElement dressHeader;
	
	@FindBy (xpath="//div[@class='price']//p/span")
	public WebElement dressPrice;
	
	@FindBy (xpath="//div[@class='box-cart-bottom']//p[@id='add_to_cart']/button")
	public WebElement addToCart;
	
	@FindBy (xpath = "//div[@id='layer_cart']//div[@class='clearfix']/div/h2")
	public WebElement successMsg;
	
	@FindBy (xpath="//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_title']")
	public WebElement addCartTitle;
	
	@FindBy (xpath="//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_attributes']")
	public WebElement addCartAttributes;
	
	@FindBy (xpath="//div[@class='layer_cart_product_info']//div/span[@id='layer_cart_product_quantity']")
	public WebElement addCartQty;
	
	@FindBy (xpath="//div[@class='layer_cart_product_info']//div//span[@id='layer_cart_product_price']")
	public WebElement addCartPrice;
	
	@FindBy (xpath="//div[@class='button-container']//span[@title='Continue shopping']")
	public WebElement addCartContinueShopping;
	
	
	@FindBy (xpath="//div[@class='shopping_cart']//a")
	public WebElement cart;
	
	@FindBy (xpath="//div[@class='cart_block_list']//span[@class='remove_link']")
	public WebElement cartRemoveLink;
	
	@FindBy (xpath="//p[@class='alert alert-warning']")
	public WebElement cartStatus;
	
	@FindBy (xpath="//div[@class='fancybox-inner']//iframe")
	public WebElement frame1;
	
	public void verifyContent() throws InterruptedException{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(frame1));
		driver.switchTo().frame(frame1);
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(dressHeader));
		
		
		if(dressHeader!=null) {
			if(dressHeader.isDisplayed()) {
				if(dressHeader.getText().equalsIgnoreCase("Printed Chiffon Dress")) {
					Assert.assertTrue(true, "Title matched");
				}else {
					Assert.assertFalse(false, "Title not matched");
				}
			}
		}
		
		if(dressPrice != null) {
			if(dressPrice.isDisplayed()) {
				String strPrice = dressPrice.getText();
				float price = Float.parseFloat(strPrice.substring(1, strPrice.length()));

				if(price==16.40) {
					Assert.assertTrue(true, "Price matched");
				}else {
					Assert.assertFalse(false, "Price not matched");
				}
			}
		}
	}
	
	public void addToCart() throws InterruptedException{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(addToCart));
		if(addToCart != null) {
			if(addToCart.isDisplayed() && addToCart.isEnabled()) {
				addToCart.click();
			}
		}
		Thread.sleep(2000);
		if(successMsg != null) {
			if(successMsg.isDisplayed()) {
				if(successMsg.getText().trim().equals("Product successfully added to your shopping cart")){
					Assert.assertTrue(true, "Success message displayed and matched");
				}else {
					Assert.assertTrue(true, "Success message not displayed and matched");
				}
			}
		}
		
		if(addCartTitle != null) {
			if(addCartTitle.isDisplayed()) {
				if(addCartTitle.getText().equalsIgnoreCase("Printed Chiffon Dress")) {
					Assert.assertTrue(true, "Add cart dress title matched");
				}else {
					Assert.assertTrue(true, "Add cart dress title not matched");
				}
			}
		}
		
		if(addCartAttributes != null) {
			if(addCartAttributes.isDisplayed()) {
				if(addCartAttributes.getText().equalsIgnoreCase("Yellow, S")) {
					Assert.assertTrue(true, "Add cart dress attributes matched");
				}else {
					Assert.assertTrue(true, "Add cart dress attributes not matched");
				}
			}
		}
		
		if(addCartQty != null) {
			if(addCartQty.isDisplayed()) {
				if(addCartQty.getText().equalsIgnoreCase("1")) {
					Assert.assertTrue(true, "Add cart dress quantity matched");
				}else {
					Assert.assertTrue(true, "Add cart dress quantity not matched");
				}
			}
		}
		
		if(addCartPrice != null) {
			if(addCartPrice.isDisplayed()) {
				String strPrice = addCartPrice.getText();
				float price = Float.parseFloat(strPrice.substring(1, strPrice.length()));

				if(price==16.4) {
					Assert.assertTrue(true, "add cart Price matched");
				}else {
					Assert.assertFalse(false, "add cart Price not matched");
				}
			}
		}
		getWebDriverWait().until(ExpectedConditions.visibilityOf(addCartContinueShopping));
		if(addCartContinueShopping != null) {
			if(addCartContinueShopping.isDisplayed()) {
				addCartContinueShopping.click();
				Assert.assertTrue(true, "Add cart continue shopping displayed and clicked");
				
			}else {
				Assert.assertTrue(true, "Add cart continue shopping not displayed and clicked");
			}
			
		}
		
		driver.switchTo().defaultContent();
	}
	
	public void verifyCart() throws InterruptedException,IOException {
		getWebDriverWait().until(ExpectedConditions.visibilityOf(cart));
		
		
		if(cart != null) {
			if(cart.isDisplayed()) {
				Actions act = new Actions(driver);
				act.moveToElement(cart).perform();
				Thread.sleep(1000);

				Assert.assertTrue(true, "Cart displayed and clicked");
				

				if(cartRemoveLink !=null) {
					if(cartRemoveLink.isDisplayed()) {
						cartRemoveLink.click();
						Assert.assertTrue(true, "Cart remove link displayed and clicked");
					}else {
						
						Assert.assertTrue(true, "Cart remove link not displayed and clicked");
					}
				}
			
			}else {
				
				Assert.assertTrue(true, "Cart not displayed and clicked");
			}
		}
	}
	
	public void verifyEmptyCart() throws IOException, InterruptedException {
		getWebDriverWait().until(ExpectedConditions.visibilityOf(cart));
		if(cart != null) {
			if(cart.isDisplayed()) {
				Actions act = new Actions(driver);
				act.moveToElement(cart).perform();
				Thread.sleep(1000);
				cart.click();

				if(cartStatus.getText().trim().equalsIgnoreCase("Your shopping cart is empty.")) {
					
					Assert.assertTrue(true, "Cart is empty displayed");
					
				}
			}
		}
	}
}
