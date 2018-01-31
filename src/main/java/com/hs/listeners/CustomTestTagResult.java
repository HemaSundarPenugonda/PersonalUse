package com.hs.listeners;

import org.testng.ISuiteResult;
import com.hs.utils.Utilities;

public class CustomTestTagResult {
    private ISuiteResult currentTestResult;

    public CustomTestTagResult(ISuiteResult currentTestResult) {
        this.currentTestResult = currentTestResult;
    }

    public String getTestName() {
        return currentTestResult.getTestContext().getName();
    }

    public String getTestDuration() {
        return Utilities.timeConversion(currentTestResult.getTestContext().getEndDate().getTime() - currentTestResult.getTestContext().getStartDate().getTime());
    }

    public String getTestStatus() {

        int allPassedResults = currentTestResult.getTestContext().getPassedTests().getAllResults().size();
        int allFailedResults = currentTestResult.getTestContext().getFailedTests().getAllResults().size();
        int allSkippedResults = currentTestResult.getTestContext().getSkippedTests().getAllResults().size();
        int allPartialSuccessResults = currentTestResult.getTestContext().getFailedButWithinSuccessPercentageTests().getAllResults().size();

        int allMethodsCount = allPassedResults + allFailedResults + allPartialSuccessResults + allSkippedResults;

        if (allMethodsCount == 0) {
            return "NO METHODS";
        } else {
            String str = "";
            if (allPassedResults > 0)
                str = str + "| " + "<span style=\"color:green;\">" + allPassedResults + " PASS</span>";
            if (allFailedResults > 0)
                str = str + "| " + "<span style=\"color:red;\">" +allFailedResults + " FAIL</span>";
            if (allPartialSuccessResults > 0)
                str = str + "| " + "<span style=\"color:orange;\">" + allPartialSuccessResults + " PARTIAL_SUCCESS</span>";
            if (allSkippedResults > 0)
                str = str + "| " + "<span style=\"color:grey;\">" + allSkippedResults + " SKIP</span>";

            return str;


        }

    }

    public String getUniqueTestTagName() {
        return getTestName().replace(" ", "");
    }
}