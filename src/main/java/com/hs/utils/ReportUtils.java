package com.hs.utils;

import com.hs.listeners.CustomTestMethodResult;
import com.hs.testDataBeans.FilePaths;
import com.hs.testDataBeans.HtmlReportStringsBean;
import com.hs.testDataBeans.TestData;
import org.testng.ISuiteResult;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportUtils {

    public static List<ITestResult> getAllTestMethodResults(ISuiteResult indTestResult) {
        Set<ITestResult> allPassedResults = indTestResult.getTestContext().getPassedTests().getAllResults();
        Set<ITestResult> allFailedResults = indTestResult.getTestContext().getFailedTests().getAllResults();
        Set<ITestResult> allSkippedResults = indTestResult.getTestContext().getSkippedTests().getAllResults();
        Set<ITestResult> allPartialSuccessResults = indTestResult.getTestContext().getFailedButWithinSuccessPercentageTests().getAllResults();

        List<ITestResult> allResults = new ArrayList<>();
        allResults.addAll(allPassedResults);
        allResults.addAll(allFailedResults);
        allResults.addAll(allSkippedResults);
        allResults.addAll(allPartialSuccessResults);
        return allResults;
    }

    public static String prepareLogsPopupHtml(CustomTestMethodResult currentRow) {
        HtmlReportStringsBean htmlReportReplaceStrings = TestData.getHtmlReportStrings();

        String exceptionPopup;
        exceptionPopup = Utilities.readFile(FilePaths.CUSTOMREPORT2_TEMPLATE_POPUP);

        exceptionPopup = exceptionPopup.replace(htmlReportReplaceStrings.getPopupUniqueName(), currentRow.getTestMethodUniqueName());
        exceptionPopup = exceptionPopup.replace(htmlReportReplaceStrings.getPopupBodyText(), currentRow.getStackTrace());
        exceptionPopup = exceptionPopup.replace(htmlReportReplaceStrings.getPopupLinkName(), currentRow.getExceptionName());
        return exceptionPopup;
    }
}
