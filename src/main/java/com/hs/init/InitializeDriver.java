package com.hs.init;

import com.hs.testDataBeans.TestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public enum InitializeDriver implements LaunchApp {

    IOS_LOCAL_DEV {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            File appDir = new File(System.getProperty("user.dir") + "/src/main/resources/apps/");

            Map<String, String> iOsCapabilities = TestData.getConfigData().getIosLocalDev();

            iOsCapabilities.forEach((key, value) -> {
                if (key.equalsIgnoreCase("appName")) {
                    capabilities.setCapability("app", new File(appDir, value).getAbsolutePath());
                } else {
                    capabilities.setCapability(key, value);
                }
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            IOSDriver driver = null;
            try {
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    ANDROID_LOCAL_DEV {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            File appDir = new File(System.getProperty("user.dir") + "/resources/apps/");

            Map<String, String> iOsCapabilities = TestData.getConfigData().getAndroidLocalDev();

            iOsCapabilities.forEach((key, value) -> {
                if (key.equalsIgnoreCase("appName")) {
                    capabilities.setCapability(key, new File(appDir, value).getAbsolutePath());
                } else {
                    capabilities.setCapability(key, value);
                }
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            AndroidDriver driver = null;
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    IOS_SAUCE_DEV {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            Map<String, String> iOsCapabilities = TestData.getConfigData().getIosSauceDev();

            iOsCapabilities.forEach((key, value) -> {
                    capabilities.setCapability(key, value);
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            IOSDriver driver = null;

            try {
                driver = new IOSDriver(new URL(TestData.getConfigData().getSauceLabURL()), capabilities);

//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    ANDROID_SAUCE_DEV {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, String> androidCapabilities = TestData.getConfigData().getAndroidSauceDev();

            androidCapabilities.forEach((key, value) -> {
                    capabilities.setCapability(key, value);
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
        	AndroidDriver driver = null;

            try {
//                driver = new AndroidDriver(new URL(TestData.getConfigData().getTestObjectURL()), capabilities);
                driver = new AndroidDriver(new URL(TestData.getConfigData().getSauceLabURL()), capabilities);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {}
//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
        },

    IOS_LOCAL_ALPHA {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            File appDir = new File(System.getProperty("user.dir") + "/src/main/resources/apps/");

            Map<String, String> iOsCapabilities = TestData.getConfigData().getIosLocalAlpha();

            iOsCapabilities.forEach((key, value) -> {
                if (key.equalsIgnoreCase("appName")) {
                    capabilities.setCapability("app", new File(appDir, value).getAbsolutePath());
                } else {
                    capabilities.setCapability(key, value);
                }
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            IOSDriver driver = null;
            try {
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    ANDROID_LOCAL_ALPHA {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            File appDir = new File(System.getProperty("user.dir") + "/resources/apps/");

            Map<String, String> iOsCapabilities = TestData.getConfigData().getAndroidLocalAlpha();

            iOsCapabilities.forEach((key, value) -> {
                if (key.equalsIgnoreCase("appName")) {
                    capabilities.setCapability(key, new File(appDir, value).getAbsolutePath());
                } else {
                    capabilities.setCapability(key, value);
                }
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            AndroidDriver driver = null;
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    IOS_SAUCE_ALPHA {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            Map<String, String> iOsCapabilities = TestData.getConfigData().getIosSauceAlpha();

            iOsCapabilities.forEach((key, value) -> {
                capabilities.setCapability(key, value);
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            IOSDriver driver = null;

            try {
                driver = new IOSDriver(new URL(TestData.getConfigData().getSauceLabURL()), capabilities);

//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    },

    ANDROID_SAUCE_ALPHA {
        @Override
        public DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, String> androidCapabilities = TestData.getConfigData().getAndroidLocalAlpha();

            androidCapabilities.forEach((key, value) -> {
                capabilities.setCapability(key, value);
            });
            return capabilities;
        }

        @Override
        public AppiumDriver startDriver(DesiredCapabilities capabilities) {
            AndroidDriver driver = null;

            try {
//                driver = new AndroidDriver(new URL(TestData.getConfigData().getTestObjectURL()), capabilities);
                driver = new AndroidDriver(new URL(TestData.getConfigData().getSauceLabURL()), capabilities);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {}
//                driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new CustomAppiumListener());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    }
};


interface LaunchApp {
    DesiredCapabilities setCapabilities();

    AppiumDriver startDriver(DesiredCapabilities capabilities);
}
