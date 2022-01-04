package com.aisera.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aisera.ui.framework.BasePage;

public class GoogleAboutPage extends BasePage {

	private final Logger logger = LogManager.getLogger(GoogleAboutPage.class);
	
	public GoogleAboutPage(WebDriver driver) {
		super(driver);
	}

}
