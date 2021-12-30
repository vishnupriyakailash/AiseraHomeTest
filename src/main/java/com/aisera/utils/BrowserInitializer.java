package com.aisera.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitializer {

	private Configuration config = new Configuration();

	private Properties properties = new Properties();

	private final Logger logger = LogManager.getLogger(BrowserInitializer.class);

	public BrowserInitializer() {
		setConfiguration();
	}

	private void setConfiguration() {
		properties = readConfigFile(Constants.CONFIG_FILE_PATH);
		config.setTimeOut(Integer.parseInt(properties.getProperty("timeout")));
		config.setBrowser(properties.getProperty("browser"));
	}

	public WebDriver getWebDriver() {
		return getWebDriver(config.getBrowser());
	}

	private WebDriver getWebDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			logger.info("Selecting Firefox for operation");
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			logger.info("Selecting Chrome driver for operation");
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			logger.info("Selecting IE driver for operation");
			return new InternetExplorerDriver();
		}
		return null;
	}

	private Properties readConfigFile(String file) {
		InputStream input = null;
		Properties properties = new Properties();
		try {
			input = new FileInputStream(file);
			properties.load(input);
		} catch (IOException ex) {
			logger.error("Error occured while reading property file" + ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Error occured while reading property file" + e.getMessage());
				}
			}
		}
		return properties;
	}

	public Configuration getConFiConfiguration() {
		return config;
	}
}