package com.hs.listeners;

import org.testng.ISuiteResult;
import com.hs.utils.Utilities;

public class CustomTestMethodResultsSummary {
    private ISuiteResult currentTestResult;

    public CustomTestMethodResultsSummary(ISuiteResult currentTestResult) {
        this.currentTestResult = currentTestResult;
    }

    public String getTotalTestMethodsCount() {
        return String.valueOf(currentTestResult.getTestContext().getAllTestMethods().length);
    }

    public String getTotalPassedMethodsCount() {
        return String.valueOf(currentTestResult.getTestContext().getPassedTests().size());
    }

    public String getTotalFailedMethodsCount() {
        return String.valueOf(currentTestResult.getTestContext().getFailedTests().size());
    }

    public String getTotalSkippedMethodsCount() {
        return String.valueOf(currentTestResult.getTestContext().getSkippedTests().size());
    }

    public String getTotalPartialSuccessMethodsCount() {
        return String.valueOf(currentTestResult.getTestContext().getFailedButWithinSuccessPercentageTests().size());
    }

    public String getTimeDuration(){
        return Utilities.timeConversion(currentTestResult.getTestContext().getStartDate().getTime() - currentTestResult.getTestContext().getEndDate().getTime());
    }
}
