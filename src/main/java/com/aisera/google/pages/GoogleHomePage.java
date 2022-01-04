
package com.aisera.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aisera.ui.framework.BasePage;
import com.aisera.utils.Constants;

public class GoogleHomePage extends BasePage {

	private final Logger logger = LogManager.getLogger(GoogleHomePage.class);

	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = Constants.ABOUT_LINK)
	WebElement aboutLink;

	@FindBy(linkText = Constants.STORE_LINK)
	WebElement storeLink;

	public GoogleStorePage clickStoreLink() {

		logger.info("Clicking store link");

		clickLink(storeLink);

		return new GoogleStorePage(driver);
	}

	public GoogleAboutPage clickAboutLink() {

		logger.info("Clicking about link");

		clickLink(aboutLink);

		return new GoogleAboutPage(driver);
	}

	public boolean isStoreExists() {
		return (storeLink == null) ? false : true;
	}

	public boolean isAboutExists() {
		return (aboutLink == null) ? false : true;
	}
}
