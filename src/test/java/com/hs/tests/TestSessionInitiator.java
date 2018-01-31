package com.hs.tests;

import java.util.concurrent.TimeUnit;

import com.hs.init.InitializeDriver;
import com.hs.testDataBeans.TestData;
import com.hs.utils.CommonEnums;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * This is core of framework wherein all the initializations are done.
 * Including browser configuration, page objects, config and yaml.
 */
public class TestSessionInitiator {
    public AppiumDriver driver;

    @BeforeTest
    public void _configureMobile() {
        //		Define a enum in configDatabean class (Use existing enum)
        String testEnvironment = TestData.getConfigData().getTestEnvironment().toUpperCase();
        String appEnvironment = TestData.getConfigData().getAppEnvironment().toUpperCase();
        String deviceType = TestData.getConfigData().getDeviceType().toUpperCase();

        DesiredCapabilities capabilities = getDriverType(deviceType, testEnvironment, appEnvironment).setCapabilities();
        driver = getDriverType(deviceType, testEnvironment, appEnvironment).startDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(TestData.getConfigData().getImplicitTimeOut(), TimeUnit.SECONDS);

    }

    private InitializeDriver getDriverType(String deviceType, String testEnvironment, String appEnvironment) {
        CommonEnums.DeviceType deviceTypeEnum = CommonEnums.DeviceType.valueOf(deviceType);
        CommonEnums.TestEnvironment testEnvironmentEnum = CommonEnums.TestEnvironment.valueOf(testEnvironment);
        CommonEnums.AppEnvironment appEnvironmentEnum = CommonEnums.AppEnvironment.valueOf(appEnvironment);

        switch (deviceTypeEnum) {
            case IOS:
                switch (testEnvironmentEnum) {
                    case LOCAL:
                        switch (appEnvironmentEnum) {
                            case DEV:
                                return InitializeDriver.IOS_LOCAL_DEV;
                            case ALPHA:
                                return InitializeDriver.IOS_LOCAL_ALPHA;
                        }

                    case SAUCE:
                        switch (appEnvironmentEnum) {
                            case DEV:
                                return InitializeDriver.IOS_SAUCE_DEV;
                            case ALPHA:
                                return InitializeDriver.IOS_SAUCE_ALPHA;
                        }
                }
            case ANDROID: {
                switch (testEnvironmentEnum) {
                    case LOCAL:
                        switch (appEnvironmentEnum) {
                            case DEV:
                                return InitializeDriver.ANDROID_LOCAL_DEV;
                            case ALPHA:
                                return InitializeDriver.ANDROID_LOCAL_ALPHA;
                        }
                    case SAUCE:
                        switch (appEnvironmentEnum) {
                            case DEV:
                                return InitializeDriver.ANDROID_SAUCE_DEV;
                            case ALPHA:
                                return InitializeDriver.ANDROID_SAUCE_ALPHA;
                        }
                }
            }
            default:
                return InitializeDriver.IOS_LOCAL_DEV;
        }
    }

    @AfterTest
    public void quitSession() {
        driver.quit();
    }

}
