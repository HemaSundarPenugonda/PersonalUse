package com.hs.tests;

import com.hs.pages.LaunchPageActions;
import com.hs.utils.CommonEnums;
import com.hs.utils.CustomLogging;
import com.hs.utils.Utilities;

public class BaseTest extends TestSessionInitiator {

    public void navigateToLoginPage() {

        LaunchPageActions launchPage = new LaunchPageActions(driver);

        launchPage.waitForProgressBar();

        if (Utilities.getDeviceOS() == CommonEnums.DeviceType.IOS) {
            launchPage.acceptNotifications();
            CustomLogging.writeToReport("INFO: Notification accepted");
        }

        launchPage.switchToEnglishLocale();
        CustomLogging.writeToReport("INFO: switched to English locale");

        launchPage.navigateToLoginPage();
        CustomLogging.writeToReport("INFO: Navigated to login page");
    }

}
