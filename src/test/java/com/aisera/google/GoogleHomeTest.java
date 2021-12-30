package com.aisera.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aisera.google.pages.GoogleHomePage;
import com.aisera.utils.BrowserInitializer;
import static com.aisera.utils.Constants.*;

public class GoogleHomeTest {

	WebDriver driver = null;

	private final Logger logger = LogManager.getLogger(GoogleHomeTest.class);

	BrowserInitializer initializer = new BrowserInitializer();

	@BeforeClass
	public void driverSetup() {
		driver = initializer.getWebDriver();
	}

	@Test
	public void testGoogleHome() {

		logger.info("Start - testGoogleHome test method");

		logger.info("Launching url :" + GOOGLE_URL);

		driver.get(GOOGLE_URL);

		GoogleHomePage homePage = PageFactory.initElements(driver, GoogleHomePage.class);

		Assert.assertNotNull(homePage, "Problem loading google home page");

		Assert.assertTrue(homePage.isAboutExists(), "About Link is not present");

		Assert.assertTrue(homePage.isStoreExists(), "Store Link is not present");

		homePage.clickAboutLink();

		String currentURL = null;

		currentURL = homePage.getCurrentUrl();

		Assert.assertTrue(currentURL.startsWith(ABOUT_URL));

		logger.info("Navigating to google page");

		driver.navigate().back();

		homePage.clickStoreLink();

		currentURL = homePage.getCurrentUrl();

		Assert.assertTrue(currentURL.startsWith(STORE_URL));

		logger.info("End - testGoogleHome test method");

	}

	@AfterClass
	public void driverShutdown() {
		logger.info("Closing all opened browsers");
		driver.quit();
	}
}
