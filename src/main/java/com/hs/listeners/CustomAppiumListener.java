package com.hs.listeners;

import io.appium.java_client.events.api.general.AlertEventListener;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.Reporter;

public class CustomAppiumListener implements AppiumWebDriverEventListener, AlertEventListener{

    /**
     * This action will be performed each time before {@link Alert#accept()}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which is being accepted
     */
    @Override
    public void beforeAlertAccept(WebDriver driver, Alert alert) {

    }

    /**
     * This action will be performed each time after {@link Alert#accept()}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which has been accepted
     */
    @Override
    public void afterAlertAccept(WebDriver driver, Alert alert) {

    }

    /**
     * This action will be performed each time before {@link Alert#dismiss()}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which which is being dismissed
     */
    @Override
    public void afterAlertDismiss(WebDriver driver, Alert alert) {

    }

    /**
     * This action will be performed each time after {@link Alert#dismiss()}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which has been dismissed
     */
    @Override
    public void beforeAlertDismiss(WebDriver driver, Alert alert) {

    }

    /**
     * This action will be performed each time before
     * {@link Alert#sendKeys(String)}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which is receiving keys
     * @param keys   Keys which are being sent
     */
    @Override
    public void beforeAlertSendKeys(WebDriver driver, Alert alert, String keys) {

    }

    /**
     * This action will be performed each time after
     * {@link Alert#sendKeys(String)}
     *
     * @param driver WebDriver
     * @param alert  {@link Alert} which has received keys
     * @param keys   Keys which have been sent
     */
    @Override
    public void afterAlertSendKeys(WebDriver driver, Alert alert, String keys) {

    }

    /**
     * This action will be performed each time before
     * {@link Alert#setCredentials(Credentials)} and
     * {@link Alert#authenticateUsing(Credentials)}
     *
     * @param driver      WebDriver
     * @param alert       {@link Alert} which is receiving user credentials
     * @param credentials which are being sent
     */
    @Override
    public void beforeAuthentication(WebDriver driver, Alert alert, Credentials credentials) {

    }

    /**
     * This action will be performed each time after
     * {@link Alert#setCredentials(Credentials)} and
     * {@link Alert#authenticateUsing(Credentials)}
     *
     * @param driver      WebDriver
     * @param alert       {@link Alert} which has received user credentials
     * @param credentials which have been sent
     */
    @Override
    public void afterAuthentication(WebDriver driver, Alert alert, Credentials credentials) {

    }

    /**
     * Called before {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)}.
     *
     * @param element the WebElement being used for the action
     * @param driver  WebDriver
     */
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    /**
     * Called after {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)} .
     * Not called, if an exception is thrown.
     *
     * @param element the WebElement being used for the action
     * @param driver  WebDriver
     */
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    /**
     * This action will be performed each time before {@link Alert#accept()}
     *
     * @param driver WebDriver
     */
    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    /**
     * This action will be performed each time after {@link Alert#accept()}
     *
     * @param driver WebDriver
     */
    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    /**
     * This action will be performed each time before {@link Alert#dismiss()}
     *
     * @param driver WebDriver
     */
    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    /**
     * This action will be performed each time after {@link Alert#dismiss()}
     *
     * @param driver WebDriver
     */
    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    /**
     * Called before {@link WebDriver#get get(String url)} respectively
     * {@link WebDriver.Navigation#to navigate().to(String url)}.
     *
     * @param url    URL
     * @param driver WebDriver
     */
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    /**
     * Called after {@link WebDriver#get get(String url)} respectively
     * {@link WebDriver.Navigation#to navigate().to(String url)}. Not called, if an
     * exception is thrown.
     *
     * @param url    URL
     * @param driver WebDriver
     */
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    /**
     * Called before {@link WebDriver.Navigation#back navigate().back()}.
     *
     * @param driver WebDriver
     */
    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    /**
     * Called after {@link WebDriver.Navigation navigate().back()}. Not called, if an
     * exception is thrown.
     *
     * @param driver WebDriver
     */
    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    /**
     * Called before {@link WebDriver.Navigation#forward navigate().forward()}.
     *
     * @param driver WebDriver
     */
    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    /**
     * Called after {@link WebDriver.Navigation#forward navigate().forward()}. Not called,
     * if an exception is thrown.
     *
     * @param driver WebDriver
     */
    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    /**
     * Called before {@link WebDriver.Navigation#refresh navigate().refresh()}.
     *
     * @param driver WebDriver
     */
    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    /**
     * Called after {@link WebDriver.Navigation#refresh navigate().refresh()}. Not called,
     * if an exception is thrown.
     *
     * @param driver WebDriver
     */
    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    /**
     * Called before {@link WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link WebDriver#findElements WebDriver.findElements(...)}, or {@link WebElement#findElement
     * WebElement.findElement(...)}, or {@link WebElement#findElement WebElement.findElements(...)}.
     *
     * @param by      locator being used
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param driver  WebDriver
     */
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    /**
     * Called after {@link WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link WebDriver#findElements WebDriver.findElements(...)}, or {@link WebElement#findElement
     * WebElement.findElement(...)}, or {@link WebElement#findElement WebElement.findElements(...)}.
     *
     * @param by      locator being used
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param driver  WebDriver
     */
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    /**
     * Called before {@link WebElement#click WebElement.click()}.
     *
     * @param element the WebElement being used for the action
     * @param driver  WebDriver
     */
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    /**
     * Called after {@link WebElement#click WebElement.click()}. Not called, if an exception is
     * thrown.
     *
     * @param element the WebElement being used for the action
     * @param driver  WebDriver
     */
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    /**
     * Called before {@link WebElement#clear WebElement.clear()}, {@link WebElement#sendKeys
     * WebElement.sendKeys(...)}.
     *
     * @param element    the WebElement being used for the action
     * @param driver     WebDriver
     * @param keysToSend
     */
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    /**
     * Called after {@link WebElement#clear WebElement.clear()}, {@link WebElement#sendKeys
     * WebElement.sendKeys(...)}}. Not called, if an exception is thrown.
     *
     * @param element    the WebElement being used for the action
     * @param driver     WebDriver
     * @param keysToSend
     */
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    /**
     * Called before {@link RemoteWebDriver#executeScript(String, Object[]) }
     *
     * @param script the script to be executed
     * @param driver WebDriver
     */
    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    /**
     * Called after {@link RemoteWebDriver#executeScript(String, Object[]) }.
     * Not called if an exception is thrown
     *
     * @param script the script that was executed
     * @param driver WebDriver
     */
    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    /**
     * Called whenever an exception would be thrown.
     *
     * @param throwable the exception that will be thrown
     * @param driver    WebDriver
     */
    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }
}
