package com.amazon.locatorpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandinPage {
	
	
	public LandinPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

		@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/rs_search_src_text")
		public WebElement textBoxSearch;
}
