package com.aisera.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aisera.google.pages.GoogleAboutPage;
import com.aisera.google.pages.GoogleHomePage;
import com.aisera.google.pages.GoogleStorePage;
import com.aisera.ui.base.BaseTest;
import static com.aisera.utils.Constants.*;

public class GoogleHomeTest extends BaseTest{

	private final Logger logger = LogManager.getLogger(GoogleHomeTest.class);


	@Test
	public void testGoogleHome() {

		logger.info("Start - testGoogleHome test method");

		logger.info("Launching url :" + GOOGLE_URL);

		driver.get(GOOGLE_URL);

		GoogleHomePage homePage = new GoogleHomePage(driver);

		Assert.assertNotNull(homePage, "Problem loading google home page");

		Assert.assertTrue(homePage.isAboutExists(), "About Link is not present");

		Assert.assertTrue(homePage.isStoreExists(), "Store Link is not present");

		GoogleAboutPage aboutPage = homePage.clickAboutLink();

		Assert.assertTrue(aboutPage.getCurrentUrl().startsWith(ABOUT_URL));

		logger.info("Navigating to google page");

		driver.navigate().back();

		GoogleStorePage storePage = homePage.clickStoreLink();
	
		Assert.assertTrue(storePage.getCurrentUrl().startsWith(STORE_URL));

		logger.info("End - testGoogleHome test method");
		

	}

}
