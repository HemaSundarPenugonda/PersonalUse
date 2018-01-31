package com.hs.init;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.hs.utils.SeleniumWait;

import io.appium.java_client.AppiumDriver;

public class BasePage {

	protected AppiumDriver driver;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
	}

	protected void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void hideKeyboard() {
		if (driver.getKeyboard() != null)
			driver.hideKeyboard();
		hardWait(1);
	}
}
