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
import static com.aisera.utils.Constants.TOPTAL_URL;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToptalApplyPage {

	WebDriver driver;

	private final Logger logger = LogManager.getLogger(ToptalApplyPage.class);

	public ToptalApplyPage(WebDriver driver) {
		this.driver = driver;
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

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isPageOpened() {
		return driver.getCurrentUrl().startsWith(TOPTAL_URL);
	}

	public void setFullName(String fullname) {
		logger.info("Entering full name");
		scrollElementIntoView(fullName);
		fullName.clear();
		fullName.sendKeys(fullname);
	}

	public void setEmail(String emailId) {
		logger.info("Entering email");
		scrollElementIntoView(email);
		email.clear();
		email.sendKeys(emailId);
	}

	public void setPassword(String pwd) {
		logger.info("Entering password");
		scrollElementIntoView(password);
		password.clear();
		password.sendKeys(pwd);
	}

	public void setConfirmPassword(String cfmPwd) {
		logger.info("Entering confirm password");
		scrollElementIntoView(confirmPassword);
		confirmPassword.clear();
		confirmPassword.sendKeys(cfmPwd);
	}

	public void selectTalentKind(String type) {

		logger.info("Selecting talent type");
		scrollElementIntoView(talentKind);
		talentKind.click();
		ExpectedConditions.visibilityOfAllElements(talentKindItems);
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
		scrollElementIntoView(submit);
		submit.click();
	}

	public void acceptCookiePolicy() {
		try {
			logger.info("Accepting cookie by clicking Got it button");
			cookiePolicyAccept.click();
		} catch (Exception excep) {
			logger.info("No cookies accepted");
		}

	}

	private void scrollElementIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
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
