package com.hs.testDataBeans;

import com.hs.utils.Utilities;

import java.util.Map;

public class ConfigDataBean {

    private String browser;
    private int implicitTimeOut;
    private int explicitTimeOut;
    private String seleniumServer;
    private String testEnvironment;
    private String appEnvironment;
    private String deviceType;
    private String sauceLabURL;
    private String testObjectURL;
    private String authorization;

    private Map<String, String> androidLocalDev;
    private Map<String, String> iosLocalDev;
    private Map<String, String> iosSauceDev;
    private Map<String, String> androidSauceDev;

    private Map<String, String> androidLocalAlpha;
    private Map<String, String> iosLocalAlpha;
    private Map<String, String> iosSauceAlpha;
    private Map<String, String> androidSauceAlpha;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getImplicitTimeOut() {
        return implicitTimeOut;
    }

    public void setImplicitTimeOut(int implicitTimeOut) {
        String property = Utilities.getEffectiveConfig("implicitTimeOut", String.valueOf(implicitTimeOut));
        this.implicitTimeOut = Integer.parseInt(property);
    }

    public int getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public void setExplicitTimeOut(int explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
    }

    public String getSeleniumServer() {
        return seleniumServer;
    }

    public void setSeleniumServer(String seleniumServer) {
        this.seleniumServer = seleniumServer;
    }

    public Map<String, String> getAndroidLocalDev() {
        return androidLocalDev;
    }

    public void setAndroidLocalDev(Map<String, String> androidLocalDev) {
        this.androidLocalDev = androidLocalDev;
    }

    public Map<String, String> getIosLocalDev() {
        return iosLocalDev;
    }

    public void setIosLocalDev(Map<String, String> iosLocalDev) {
        this.iosLocalDev = iosLocalDev;
    }

    public Map<String, String> getIosSauceDev() {
        return iosSauceDev;
    }

    public void setIosSauceDev(Map<String, String> iosSauceDev) {
        this.iosSauceDev = iosSauceDev;
    }

    public String getTestEnvironment() {
        return testEnvironment;
    }

    public void setTestEnvironment(String testEnvironment) {
        this.testEnvironment = Utilities.getEffectiveConfig("testEnvironment", testEnvironment);
    }

    public String getAppEnvironment() {
        return appEnvironment;
    }

    public void setAppEnvironment(String appEnvironment) {
        this.appEnvironment = Utilities.getEffectiveConfig("appEnvironment", appEnvironment);
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = Utilities.getEffectiveConfig("deviceType", deviceType);
    }

    public String getSauceLabURL() {
        return sauceLabURL;
    }

    public void setSauceLabURL(String sauceLabURL) {
        this.sauceLabURL = sauceLabURL;
    }

	public Map<String, String> getAndroidSauceDev() {
		return androidSauceDev;
	}

	public void setAndroidSauceDev(Map<String, String> androidSauceDev) {
		this.androidSauceDev = androidSauceDev;
	}

    public String getTestObjectURL() {
        return testObjectURL;
    }

    public void setTestObjectURL(String testObjectURL) {
        this.testObjectURL = testObjectURL;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Map<String, String> getAndroidLocalAlpha() {
        return androidLocalAlpha;
    }

    public void setAndroidLocalAlpha(Map<String, String> androidLocalAlpha) {
        this.androidLocalAlpha = androidLocalAlpha;
    }

    public Map<String, String> getIosLocalAlpha() {
        return iosLocalAlpha;
    }

    public void setIosLocalAlpha(Map<String, String> iosLocalAlpha) {
        this.iosLocalAlpha = iosLocalAlpha;
    }

    public Map<String, String> getIosSauceAlpha() {
        return iosSauceAlpha;
    }

    public void setIosSauceAlpha(Map<String, String> iosSauceAlpha) {
        this.iosSauceAlpha = iosSauceAlpha;
    }

    public Map<String, String> getAndroidSauceAlpha() {
        return androidSauceAlpha;
    }

    public void setAndroidSauceAlpha(Map<String, String> androidSauceAlpha) {
        this.androidSauceAlpha = androidSauceAlpha;
    }

}
