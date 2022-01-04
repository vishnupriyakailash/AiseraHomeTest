package com.aisera.ui.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aisera.utils.BrowserFactory;

public class BaseTest {

	private final Logger logger = LogManager.getLogger(BaseTest.class);
	
	BrowserFactory factory = BrowserFactory.getInstance();

	protected WebDriver driver = null;

	@BeforeClass
	public void beforeSuite() {
		logger.info("Getting the driver object");
		driver = factory.getInitialzer().getWebDriver();

	}

	@AfterSuite
	public void afterSuite() {
		logger.info("Closing the browser");
		 driver.quit();
	}

}
