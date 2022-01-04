package com.aisera.utils;

public class BrowserFactory {

	private static BrowserFactory factory = null;

	private BrowserInitializer initialzer;

	public BrowserInitializer getInitialzer() {
		return initialzer;
	}

	private BrowserFactory() {
		initialzer = new BrowserInitializer();
	}

	public static synchronized BrowserFactory getInstance() {
		if (factory == null) {
			factory = new BrowserFactory();
		}
		return factory;
	}

}
