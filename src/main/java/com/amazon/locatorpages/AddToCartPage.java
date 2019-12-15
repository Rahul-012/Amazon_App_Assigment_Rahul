package com.amazon.locatorpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	public AddToCartPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator ="new UiSelector().textContains(\"rupees\")")
	public  WebElement priceOnAddToCartPge;
	
	@AndroidFindBy(id ="action_bar_cart_count")
	public  WebElement iconAddProductTocart;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().textContains(\"LED\")")
	public WebElement productDesc;
	
	/**This method will get product Price
	 * 
	 * @return
	 */
	public String getProductPriceAddToCartPage(){
		String price[]=priceOnAddToCartPge.getText().split(" ");
		return price[1];
		
	}
	
	/**
	 * 
	 */
	public String getProductDescription(){
		return productDesc.getText();
	}
	
	
}
