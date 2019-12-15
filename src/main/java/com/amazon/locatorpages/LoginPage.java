package com.amazon.locatorpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.commonfunctions.CommonLib;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class LoginPage {

	public LoginPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "ap_email_login")
	public WebElement textBoxEmail;
	
	@AndroidFindBy(xpath = "//*[text()='Continue']")
	public WebElement btnContinue;
	
	@AndroidFindBy(id = "ap_password")
	public WebElement textBoxPassword;
	
	@AndroidFindBy(id = "signInSubmit")
	public WebElement btnLogin;
	
	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/sso_welcome")
	public WebElement textWelcome;
	
	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/sso_continue")
	public WebElement isCustomerLoggedIn;
	
	
	public void doLogin(String username,String password){
	    
		AndroidDriver androidDriver=  (AndroidDriver) new WebDriverTestCase().getDriver().getUnderLayingDriver();
		AlreadyACustomer aCustomer=new AlreadyACustomer(androidDriver);
		WebDriverWait driverWait=new WebDriverWait(androidDriver, 90);
		driverWait.until(ExpectedConditions.visibilityOf(aCustomer.signInBtn));
		aCustomer.signInBtn.click();
		driverWait.until(ExpectedConditions.visibilityOf(textBoxEmail));
		textBoxEmail.sendKeys(username);
		CommonLib.scrollAndClick("Continue");
		driverWait.until(ExpectedConditions.visibilityOf(textBoxPassword));
		textBoxPassword.sendKeys(password);
		btnLogin.click();
		LandinPage landinPage=new LandinPage(androidDriver)	;
		driverWait.until(ExpectedConditions.visibilityOf(landinPage.textBoxSearch));
	}
	
	public String isCustomerLoggedIn(){
		return textWelcome.getText();
	}
}
