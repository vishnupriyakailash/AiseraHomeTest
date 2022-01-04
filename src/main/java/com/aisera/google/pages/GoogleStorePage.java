package com.aisera.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aisera.ui.framework.BasePage;

public class GoogleStorePage extends BasePage{

	private final Logger logger = LogManager.getLogger(GoogleStorePage.class);

	public GoogleStorePage(WebDriver driver) {
		super(driver);
	}

}
