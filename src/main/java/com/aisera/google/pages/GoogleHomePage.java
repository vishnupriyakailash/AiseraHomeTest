
package com.aisera.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aisera.utils.Constants;

public class GoogleHomePage {

	WebDriver driver;

	private final Logger logger = LogManager.getLogger(GoogleHomePage.class);

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(linkText = Constants.ABOUT_LINK)
	WebElement aboutLink;

	@FindBy(linkText = Constants.STORE_LINK)
	WebElement storeLink;

	public void clickStoreLink() {
		logger.info("Clicking store link");
		storeLink.click();
	}

	public void clickAboutLink() {
		logger.info("Clicking about link");
		aboutLink.click();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isStoreExists() {
		return (storeLink == null) ? false : true;
	}

	public boolean isAboutExists() {
		return (aboutLink == null) ? false : true;
	}
}
