package com.amazom.tc;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Logger;

import jxl.common.Assert;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.locatorpages.AddToCartPage;
import com.amazon.locatorpages.LandinPage;
import com.amazon.locatorpages.LoginPage;
import com.amazon.locatorpages.SearchResult;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;


public class Amazon_TC extends WebDriverBaseTestPage<WebDriverTestPage>  {
	Log4JLogger log=new Log4JLogger();
	
	/**Variable Declarrations
	 * 
	 */
	String username="9074679699";
	String password="amazon@123";
			
	@Test(priority=1)
	public void loginToApp() throws InterruptedException{
	
		com.qmetry.qaf.automation.util.Reporter.log("--------------> App Invoked successfully<--------------------------");
		AndroidDriver androidDriver = (AndroidDriver) new WebDriverTestCase().getDriver().getUnderLayingDriver();
		LoginPage loginPage=new LoginPage(androidDriver);
		loginPage.doLogin(username, password);
		LandinPage landinPage=new LandinPage(androidDriver)	;
		Assert.verify(landinPage.textBoxSearch.isDisplayed(), "Not Logged In successfully");
		com.qmetry.qaf.automation.util.Reporter.log("--------------> Landing page displayed successfully<--------------------------");

	}

	String tv="65 inch tv";
	@Test(priority=2)
	public void searchResultRandomlyAndAddToCart() throws InterruptedException{
		AndroidDriver androidDriver = (AndroidDriver) new WebDriverTestCase().getDriver().getUnderLayingDriver();
		SearchResult result=new SearchResult(androidDriver);
		result.textBoxSearch.sendKeys(tv);
		com.qmetry.qaf.automation.util.Reporter.log("--------------> Enter search keyword "+tv +"successfully<--------------------------");
		androidDriver.pressKeyCode(AndroidKeyCode.ENTER);
		String productPriceAndDetails=result.searchResultAndAddProducts();
		
		AddToCartPage addToCartPage=new AddToCartPage(androidDriver);
		Assert.verify(addToCartPage.iconAddProductTocart.isDisplayed(), "Unable search Product");	
		com.qmetry.qaf.automation.util.Reporter.log("--------------> Search List is displayed successfully<--------------------------");
		
		Assert.verify(productPriceAndDetails.contains(addToCartPage.getProductPriceAddToCartPage()),"Product Price is not Matched");
		Assert.verify(addToCartPage.getProductDescription().contains(productPriceAndDetails),"Product Description is not matched");
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
}

	

