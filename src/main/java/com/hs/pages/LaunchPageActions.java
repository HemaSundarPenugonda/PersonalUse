package com.hs.pages;

import com.hs.utils.ElementUtils;
import com.hs.utils.ReportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hs.init.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LaunchPageActions extends BasePage{

public static final String pageName;
	static {
		pageName = "Launch Page";

	}
	public LaunchPageActions(AppiumDriver driver) {
		super( driver);
		PageFactory.initElements(driver, this);
	}
//=================================T O P / H E A D E R   P A N E L   E L E M E N T S============================================
	
	public By hamburger = ElementUtils.getLocator(pageName, "icon_hamburger");
	public By englishLanguage = ElementUtils.getLocator(pageName, "toggleLink_englishLanguage");
	public By button_loginWithTrueId = ElementUtils.getLocator(pageName, "button_LoginWithTrueID");
	public By progressBar = ElementUtils.getLocator(pageName, "progressBar");


	public void navigateToLoginPage() {

		ElementUtils.clickObject(driver, button_loginWithTrueId);
		hardWait(10);
	}

	public void acceptNotifications() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ElementUtils.acceptAlert(driver);
	}

	public void waitForProgressBar() {
		ElementUtils.waitForElementNotDisplayed(driver, progressBar);
	}

	public void switchToEnglishLocale() {

		ElementUtils.clickObject(driver, hamburger);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}

		ElementUtils.clickObject(driver, englishLanguage);
		ElementUtils.swipeLeft(driver);

	}
}