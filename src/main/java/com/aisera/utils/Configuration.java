package com.aisera.utils;

public class Configuration {
	private String browser;
	private int timeOut;

	public int getTimeOut() {
		return timeOut;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

}
