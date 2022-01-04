package com.aisera.toptal.pages;

import static com.aisera.utils.Constants.APPLY_LINK;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aisera.ui.framework.BasePage;

public class ToptalHomePage extends BasePage {

	private final Logger logger = LogManager.getLogger(ToptalHomePage.class);

	public ToptalHomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = APPLY_LINK)
	WebElement applyLink;

	public void clickApplyAsFreelancerLink() {
		logger.info("clicking Apply as a Freelancer link");
		applyLink.click();

	}

	public ToptalApplyPage clickApplyAsFreelancerLinkReturnApplyPage() {
		clickApplyAsFreelancerLink();
		return new ToptalApplyPage(driver);

	}

	public boolean isApplyLinkExists() {
		return (applyLink == null) ? false : true;
	}

}
