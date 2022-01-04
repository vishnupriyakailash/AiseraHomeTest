package com.aisera.toptal.pages;

import static com.aisera.utils.Constants.CONFIRM_PASSWORD;
import static com.aisera.utils.Constants.COOKIE_POLICY_ACCEPT;
import static com.aisera.utils.Constants.EMAIL;
import static com.aisera.utils.Constants.FULL_NAME;
import static com.aisera.utils.Constants.JOIN_TOPTAL;
import static com.aisera.utils.Constants.PASSWORD;
import static com.aisera.utils.Constants.TALENT_ITEM;
import static com.aisera.utils.Constants.TALENT_KIND_ITEMS;
import static com.aisera.utils.Constants.TALENT_KIND_SELECT;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aisera.ui.framework.BasePage;

public class ToptalApplyPage extends BasePage {

	private final Logger logger = LogManager.getLogger(ToptalApplyPage.class);

	public ToptalApplyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = FULL_NAME)
	WebElement fullName;

	@FindBy(id = EMAIL)
	WebElement email;

	@FindBy(id = PASSWORD)
	WebElement password;

	@FindBy(id = CONFIRM_PASSWORD)
	WebElement confirmPassword;

	@FindBy(id = JOIN_TOPTAL)
	WebElement submit;

	@FindBy(css = TALENT_KIND_SELECT)
	WebElement talentKind;

	@FindBy(css = TALENT_KIND_ITEMS)
	WebElement talentKindItems;

	@FindBy(className = COOKIE_POLICY_ACCEPT)
	WebElement cookiePolicyAccept;

	
	public void setFullName(String fullname) {
		logger.info("Entering full name");
		enterInputField(this.fullName, fullname);
	}

	public void setEmail(String emailId) {
		logger.info("Entering email");
		enterInputField(this.email, emailId);
	}

	public void setPassword(String pwd) {
		logger.info("Entering password");
		enterInputField(this.password, pwd);
	}

	public void setConfirmPassword(String cfmPwd) {
		logger.info("Entering confirm password");
		enterInputField(this.confirmPassword, cfmPwd);
	}

	public void selectTalentKind(String type) {

		logger.info("Selecting talent type");
		clickLink(talentKind);
		waitForElementsToAppear(talentKindItems);
		List<WebElement> options = driver.findElements(By.cssSelector(TALENT_ITEM));
		Iterator<WebElement> it = options.iterator();
		while (it.hasNext()) {
			WebElement wb = it.next();
			if (wb.getText().contains(type)) {
				wb.click();
				break;
			}

		}

	}

	public void clickOnJoin() {
		logger.info("Clicking Join button");
		clickLink(submit);
	}

	public void acceptCookiePolicy() {
		try {
			logger.info("Accepting cookie by clicking Got it button");
			cookiePolicyAccept.click();
		} catch (Exception excep) {
			logger.info("No cookies accepted");
		}

	}
	
	public void fillDetails(String type, String fullName, String email, String password, String confirmPassword) {
		selectTalentKind(type);
		setFullName(fullName);
		setEmail(email);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		clickOnJoin();
	}

	public boolean isSubmitExists() {
		return (submit == null) ? false : true;
	}

}
