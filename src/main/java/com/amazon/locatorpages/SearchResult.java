package com.amazon.locatorpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.commonfunctions.CommonLib;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SearchResult {
	public SearchResult(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement textBoxSearch;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().textContains(\"FREE delivery by Amazon\")")
	public  WebElement listOfProduct;
	
	
	/** This method is used to search and and product randomly
	 * 
	 */
	
	public String searchResultAndAddProducts(){
		String index1;
		AndroidDriver androidDriver=  (AndroidDriver) new WebDriverTestCase().getDriver().getUnderLayingDriver();
		//Adding Explicit wait
		WebDriverWait driverWait=new WebDriverWait(androidDriver, 30);
		driverWait.until(ExpectedConditions.visibilityOf(listOfProduct));
		
		List<MobileElement> containsTV = androidDriver.findElementsByAndroidUIAutomator("new UiSelector().textContains(\"FREE Delivery by Amazon\")");
		List<String> arrayList = new ArrayList<>();
		
		for(MobileElement element : containsTV) {
			System.out.println("Element - " + element.getText());		
			arrayList.add(element.getText());
		}		
		index1=  arrayList.get(new Random().nextInt(arrayList.size()));	
		String str[]=index1.split(" ");
		CommonLib.scrollTextUsingContains(str[0]);
		//Adding Explicit wait
		AddToCartPage addToCartPage=new AddToCartPage(androidDriver);
		driverWait.until(ExpectedConditions.visibilityOf(addToCartPage.iconAddProductTocart));
		return index1;
	}
	
}

