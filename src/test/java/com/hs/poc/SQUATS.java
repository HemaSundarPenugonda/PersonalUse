package com.hs.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SQUATS {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void testCoaches() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/Users/hemasundar/Downloads/160by2.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);

        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
String result = "";
        result = result + getCoachAvailability("https://www.squats.in/coach/96") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/2338") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/2303") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/580") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/794") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/2352") + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/2316")  + "\n";
        result = result + getCoachAvailability("https://www.squats.in/coach/453") + "\n";

        System.out.println(result);
        sendSMS_160by2(result);

    }

    private void sendSMS_160by2(String message) throws InterruptedException {
        driver.get("http://www.160by2.com");

        getVisibleElement(By.xpath("//*[@id='username']")).sendKeys("8867773565");
        getVisibleElement(By.xpath("//*[@id='password']")).sendKeys("14Myself");
        getVisibleElement(By.xpath("//button[text()='Login']")).click();

        driver.switchTo().frame("by2Frame");
        getVisibleElement(By.xpath("//*[@class='sms-nu-inp ib']/input")).sendKeys("8867773565");
        getVisibleElement(By.id("sendSMSMsg")).sendKeys(message);
        getVisibleElement(By.id("btnsendsms")).click();

        Thread.sleep(10000);
        Assert.assertEquals(getVisibleElement(By.id("showLate")).getText(),"Your message has been sent !!!");

    }

    private WebElement getVisibleElement(By by) {
        WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return until;

    }

    private String getCoachAvailability(String url) {
        driver.get(url);

        By nameBy = By.xpath("//*[@class='heading ng-binding']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy));
        String name = driver.findElement(nameBy).getText();

        By slotsBy = By.xpath("//*[@class='slots']/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(slotsBy));
        String slotsAvailable = driver.findElement(slotsBy).getText();

        return name + ":" + slotsAvailable;
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
