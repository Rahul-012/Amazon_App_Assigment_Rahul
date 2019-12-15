package com.amazon.commonfunctions;

import io.appium.java_client.android.AndroidDriver;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class CommonLib {
	/** This Class consist basic scroll method using  new Ui automator Library
	 * @param text
	 */
	static AndroidDriver androidDriver=  (AndroidDriver) new WebDriverTestCase().getDriver().getUnderLayingDriver();	

	public static void scrollAndClick(String text) {
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))").click();
				
	}
	
	public static void scroll(String text) {
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
				
	}
	
	public static void scrollTextUsingContains(String text) {
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+text+"\"))").click();;
				
	}
	
	public static void scrollTextUsingStartsWIth(String text) {
	androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\""+text+"\"))").click();
				
	}
	
	public static void waitForSpinnerToVisible(){
		CommonStep.waitForNotVisible("spinner.wait",50);
	}
	/**
	 * Swipe  Down 
	 * @param dimension
	 */
	public static void  swipeDown(int dimension) {
		org.openqa.selenium.Dimension dimensions = new WebDriverTestCase().getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver.swipe(0, scrollStart, 0, scrollEnd, dimension);
	}
}
