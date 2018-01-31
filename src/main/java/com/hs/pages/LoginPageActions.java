package com.hs.pages;

import com.hs.utils.CommonEnums;
import com.hs.utils.ElementUtils;
import com.hs.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hs.init.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPageActions extends BasePage {
    public static final String PAGENAME;

    static {
        PAGENAME = "Login Page";
    }

    public LoginPageActions(AppiumDriver driver) {
        super(driver);
    }

    public By textBox_username = ElementUtils.getLocator(PAGENAME, "textBox_username");

    public By textBox_password = ElementUtils.getLocator(PAGENAME, "textBox_password");

    public By button_signIn = ElementUtils.getLocator(PAGENAME, "button_signIn");

    public By text_successfulMessage = ElementUtils.getLocator(PAGENAME, "text_successfulMessage");

    public By text_accountMissingError = ElementUtils.getLocator(PAGENAME, "text_accountMissingError");

    public By text_passwordMissingError = ElementUtils.getLocator(PAGENAME, "text_passwordMissingError");

    public By text_wrongPassword = ElementUtils.getLocator(PAGENAME, "text_wrongPassword");

    public By button_cancel = ElementUtils.getLocator(PAGENAME, "button_cancel");

    public void clickCancelButton(){
        ElementUtils.clickObject(driver, button_cancel);
    }
    public void clickLogInButton() {
        ElementUtils.clickObject(driver, button_signIn);
        hardWait(10);
    }

    public String getAccountMissingError() {
        return ElementUtils.getText(driver, text_accountMissingError);
    }

    public String getPasswordMissingEoor() {
        return ElementUtils.getText(driver, text_passwordMissingError);
    }

    public String getWrongPasswordError() {
        return ElementUtils.getText(driver, text_wrongPassword);
    }

    public void enterUserName(String userName) {
        ElementUtils.sendKeys(driver, textBox_username, userName);
    }

    public void enterPassword(String pwd) {
        ElementUtils.sendKeys(driver, textBox_password, pwd);
    }

    //Update it with user type and fetch user details at run time
    public void loginIntoTrueApplication(String username, String password) {
        enterUserName(username);
        hideKeyboard();
        enterPassword(password);
        hardWait(2);
        if (Utilities.getDeviceOS() == CommonEnums.DeviceType.ANDROID)
            hideKeyboard();
        clickLogInButton();

        LaunchPageActions launchPage = new LaunchPageActions(driver);
        launchPage.waitForProgressBar();
//		Assert.assertEquals(getTextUsingXpath("//XCUIElementTypeStaticText[@name=\"Login Successful!\"]"), "Login Successful!");
    }
}
