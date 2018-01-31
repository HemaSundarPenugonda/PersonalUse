package com.hs.utils;

import com.hs.testDataBeans.TestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//ToDo: Need to refactor
public class ElementUtils {

    public static void sendKeys(WebDriver driver, By element, String val) {
        WebElement visibleElement = getVisibleElement(driver, element);
        visibleElement.clear();
        visibleElement.sendKeys(val);
    }

    public static WebElement getVisibleElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TestData.getConfigData().getExplicitTimeOut());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static String getText(WebDriver driver, By element) {
        return getVisibleElement(driver, element).getText();
    }

    /*Need to add waitForClickable code*/
    public static void clickObject(WebDriver driver, By by) {
        // wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement visibleElement = getVisibleElement(driver, by);

        try {
            visibleElement.click();
        } catch (WebDriverException e) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            visibleElement.click();
        }
    }

    public static void swipeLeft(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.90);
        int endx = (int) (size.width * 0.10);
        int starty = size.height / 2;
        int endy = starty;
        new TouchAction(driver).tap(startx, starty)/*.moveTo(endx, endy).release()*/.perform();
    }

    public static void swipeRight(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.10);
        int endx = (int) (size.width * 0.90);
        int starty = size.height / 2;
        int endy = starty;

        new TouchAction(driver).press(startx, starty).moveTo(endx, endy).release().perform();
    }

    public static void swipeDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();

        int startx = size.width / 2;
        int endx = startx;
        int starty = (int) (size.height * 0.10);
        int endy = (int) (size.height * 0.90);

        new TouchAction(driver).press(startx, starty).moveTo(endx, endy).release().perform();
    }

    public static void swipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 2;
        int endx = startx;
        int starty = (int) (size.height * 0.90);
        int endy = (int) (size.height * 0.10);

        new TouchAction(driver).press(startx, starty).moveTo(endx, endy).release().perform();

    }

    public static void shortSwipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 2;
        int endx = startx;
        int starty = (int) (size.height * 0.70);
        int endy = (int) (size.height * 0.30);

        new TouchAction(driver).press(startx, starty).moveTo(endx, endy).release().perform();
    }

    public static boolean acceptAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TestData.getConfigData().getExplicitTimeOut());

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            driver.switchTo().defaultContent();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static By getLocator(String pageName, String elementToken) {
        return getLocator(pageName, elementToken, "");
    }

    public static By getLocator(String pageName, String elementToken, String replacement) {
        String[] locator = ObjectFileReader.getELementFromFile(pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    public static String getLocatorTwo(String pageName, String token, String repl) {
        String[] locator = ObjectFileReader.getELementFromFile(pageName, token);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", repl);
        return locator[2];
    }

    /*public static By getLocator(String pageName, String elementToken, String specName, Boolean look) {
        return getLocator(pageName, elementToken, "", specName, look);
    }*/

    /*public static By getLocator(String pageName, String elementToken, String replacement, String specName, Boolean look) {
        String[] locator = ObjectFileReader.getELementFromFile(pageName, elementToken, specName, look);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }*/

    /*public static By getLocator(String pageName, String elementToken, String replacement, String replace, String specName, Boolean look) {
        String[] locator = ObjectFileReader.getELementFromFile(pageName, elementToken, specName, look);
        locator[2] = locator[2].replaceAll("\\#\\{.+\\}", replace);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }*/

    private static By getBy(String locatorType, String locatorValue) {
        switch (CommonEnums.Locators.valueOf(locatorType.toUpperCase())) {
            case ID:
                return By.id(locatorValue);
            case XPATH:
                return By.xpath(locatorValue);
            case ACCESSIBILITY:
                return MobileBy.AccessibilityId(locatorValue);
            case CSS:
                return By.cssSelector(locatorValue);
            case NAME:
                return By.name(locatorValue);
            case CLASSNAME:
                return By.className(locatorValue);
            case LINKTEXT:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    public static Boolean waitForElementNotDisplayed(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TestData.getConfigData().getExplicitTimeOut());
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}