package com.hs.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Method " + result.getName() + " Started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long timeTaken = (result.getEndMillis() - result.getStartMillis()) / 1000;
        String str;
        if (timeTaken >60) {
            timeTaken = (timeTaken / 60);
            str = timeTaken + " m";
        } else {
            str = timeTaken + " s";
        }
        System.out.println("Method " + result.getName() + " completed executing : "+ str);
        Reporter.log("Method " + result.getName() + " completed executing : "+ str);
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
