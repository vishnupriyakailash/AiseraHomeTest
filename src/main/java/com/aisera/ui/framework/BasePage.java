package com.aisera.ui.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static final int TIMEOUT = 10;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void scrollElementIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
	}

	protected boolean isPageOpened(String url) {
		return driver.getCurrentUrl().startsWith(url);
	}

	protected void enterInputField(WebElement element, String inputValue) {
		scrollElementIntoView(element);
		element.clear();
		element.sendKeys(inputValue);
	}

	protected void clickLink(WebElement element) {
		scrollElementIntoView(element);
		element.click();
	}

	protected void waitForElementsToAppear(final WebElement... elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementsToAppear(final WebElement element, int timeout) {
		new WebDriverWait(driver, timeout, POLLING).until(ExpectedConditions.visibilityOf(element));
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
