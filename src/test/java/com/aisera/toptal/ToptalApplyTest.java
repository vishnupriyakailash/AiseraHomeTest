package com.aisera.toptal;

import static com.aisera.utils.Constants.TOPTAL_URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aisera.toptal.pages.ToptalApplyPage;
import com.aisera.toptal.pages.ToptalHomePage;
import com.aisera.ui.base.BaseTest;

public class ToptalApplyTest extends BaseTest {

	private final Logger logger = LogManager.getLogger(ToptalApplyTest.class);

	private static final String INPUT_TALENT_TYPE = "Designer";
	private static final String INPUT_FULLNAME = "Vishnu Priya";
	private static final String INPUT_EMAIL = "testaisera@toptal.com";
	private static final String INPUT_PASSWORD = "password";
	private static final String INPUT_CONFIRM_PASSWORD = "password";

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

}
