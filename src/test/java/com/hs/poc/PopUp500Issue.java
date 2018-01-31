package com.hs.poc;

import com.hs.testDataBeans.TestData;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PopUp500Issue {
    static int i;
static boolean enterUserName = true;
    public static void main(String[] args) throws IOException, InterruptedException {
        String userName = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.widget.EditText";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        File appDir = new File(System.getProperty("user.dir") + "/resources/apps/");


//        capabilities.setCapability("appName", new File(appDir, "app-release.apk").getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("BROWSER_NAME", "");
        capabilities.setCapability("udid", "520016bdfe27946b");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.truemoveent.iservice.alpha");
        capabilities.setCapability("appActivity", "com.iservice.MainActivity");
        capabilities.setCapability("deviceName", "Galaxy J7 Prime");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(10000);

        By progressBar = MobileBy.className("android.widget.ProgressBar");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBar));
        getClickableElement(driver, MobileBy.AccessibilityId("sharedPage_icon_hamburger")).click();
        getClickableElement(driver, MobileBy.xpath("//android.widget.TextView[@text='EN']")).click();
        getClickableElement(driver, MobileBy.xpath("//android.widget.TextView[@text='Home']")).click();

        for (int j = 0; j < 100; j++) {

            getClickableElement(driver, MobileBy.AccessibilityId("landingPage_button_loginWithTrueId")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBar));
            if (enterUserName) {
                getVisibleElement(driver, MobileBy.xpath("//android.view.View[@resource-id='submitform']//android.widget.EditText")).sendKeys("0820951055");
                enterUserName = false;
            }
            getVisibleElement(driver, MobileBy.id("password")).sendKeys("test1234");
            getClickableElement(driver, MobileBy.id("submit")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBar));

            takeScreenShot(driver, new File("Screens/LogIn_" + i + ".png"));

            getClickableElement(driver, MobileBy.AccessibilityId("sharedPage_icon_hamburger")).click();
            getClickableElement(driver, MobileBy.xpath("//android.widget.TextView[@text='Logout']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBar));

            takeScreenShot((TakesScreenshot) driver, new File("Screens/LogOut_" + i + ".png"));
            i++;
        }

    }

    private static void takeScreenShot(TakesScreenshot driver, File destFile) throws InterruptedException, IOException {
        Thread.sleep(2000);
        File file = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, destFile);
    }

    public static WebElement getVisibleElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement getClickableElement(WebDriver driver, By by) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement until = wait.until(ExpectedConditions.elementToBeClickable(by));

        return until;
    }
}
