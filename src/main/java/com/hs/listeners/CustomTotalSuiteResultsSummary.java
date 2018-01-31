package com.hs.listeners;

import com.hs.utils.ReportUtils;
import com.hs.utils.Utilities;
import org.testng.ISuiteResult;

import java.util.Map;

class CustomTotalSuiteResultsSummary {
    private Map<String, ISuiteResult> indSuiteResults;

    CustomTotalSuiteResultsSummary(Map<String, ISuiteResult> indSuiteResults) {
        this.indSuiteResults = indSuiteResults;
    }

    int getTotalTestMethods() {
        return indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(iSuiteResult -> ReportUtils.getAllTestMethodResults(iSuiteResult).size())
                .sum();
    }

    int getTotalPassedtestMethods() {
        return indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(iSuiteResult -> iSuiteResult.getTestContext().getPassedTests().size())
                .sum();
    }

    int getTotalFailedTestMethods() {
        return indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(iSuiteResult -> iSuiteResult.getTestContext().getFailedTests().size())
                .sum();
    }

    int getTotalSkippedTestMethods() {
        return indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(iSuiteResult -> iSuiteResult.getTestContext().getSkippedTests().size())
                .sum();
    }

    int getTotalPartialSuccessTestMethods() {
        return indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(iSuiteResult -> iSuiteResult.getTestContext().getFailedButWithinSuccessPercentageTests().size())
                .sum();
    }

    String getTotalDurationSequential() {
        long sum = indSuiteResults.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToLong(iSuiteResult -> iSuiteResult.getTestContext().getEndDate().getTime() - iSuiteResult.getTestContext().getStartDate().getTime())
                .sum();
        return Utilities.timeConversion(sum);
    }

}
