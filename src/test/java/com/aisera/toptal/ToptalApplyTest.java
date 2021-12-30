package com.aisera.toptal;

import static com.aisera.utils.Constants.*;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aisera.google.GoogleHomeTest;
import com.aisera.toptal.pages.ToptalApplyPage;
import com.aisera.toptal.pages.ToptalHomePage;
import com.aisera.utils.BrowserInitializer;

public class ToptalApplyTest {

	WebDriver driver = null;

	BrowserInitializer initializer = new BrowserInitializer();

	private final Logger logger = LogManager.getLogger(GoogleHomeTest.class);

	private static final String INPUT_TALENT_TYPE = "Designer";
	private static final String INPUT_FULLNAME = "Vishnu Priya";
	private static final String INPUT_EMAIL = "testaisera@toptal.com";
	private static final String INPUT_PASSWORD = "password";
	private static final String INPUT_CONFIRM_PASSWORD = "password";

	@BeforeClass
	public void driverSetup() {
		driver = initializer.getWebDriver();
		driver.manage().timeouts().implicitlyWait(initializer.getConFiConfiguration().getTimeOut(), TimeUnit.SECONDS);
	}

	@Test
	public void testApply() {

		logger.info("Start - testApply test method");

		logger.info("Launching url :" + TOPTAL_URL);

		driver.get(TOPTAL_URL);

		ToptalHomePage homePage = PageFactory.initElements(driver, ToptalHomePage.class);

		Assert.assertNotNull(homePage, "Problem loading Toptal home page");

		Assert.assertTrue(homePage.isApplyLinkExists(), "Apply Link is not present");

		ToptalApplyPage applyPage = homePage.clickApplyAsFreelancerLinkReturnApplyPage();

		Assert.assertNotNull(applyPage, "Problem loading Toptal Apply page");

		applyPage.acceptCookiePolicy();

		applyPage.fillDetails(INPUT_TALENT_TYPE, INPUT_FULLNAME, INPUT_EMAIL, INPUT_PASSWORD, INPUT_CONFIRM_PASSWORD);

		// Just to lookat the page
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("End - testApply test method");

	}

	@AfterClass
	public void driverShutdown() {
		driver.close();
		driver.quit();
	}
}
