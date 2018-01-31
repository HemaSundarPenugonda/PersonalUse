package com.hs.listeners;

import com.hs.testDataBeans.FilePaths;
import com.hs.testDataBeans.HtmlReportStringsBean;
import com.hs.testDataBeans.TestData;
import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;
import com.hs.utils.ReportUtils;
import com.hs.utils.Utilities;

import java.io.*;
import java.util.*;

/**
 * Reporter that generates a single-page HTML report of the test results.
 */
public class CustomEmailableReport implements IReporter {
    private static final Logger LOG = Logger.getLogger(CustomEmailableReport.class);
    private HtmlReportStringsBean htmlReportReplaceStrings = TestData.getHtmlReportStrings();

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        String reportPath = outputDirectory + "/CustomizedReport2.html";
        int sNo = 0;
        try {
            FileUtils.copyFile(new File(FilePaths.CUSTOMREPORT2_TEMPLATE_TOTALREPORT), new File(reportPath));
            FileUtils.copyDirectory(new File(FilePaths.CUSTOMREPORT2_TEMPLATE_SCRIPTSFOLDER), new File(outputDirectory, "Scripts"));
            FileUtils.copyDirectory(new File(FilePaths.CUSTOMREPORT2_TEMPLATE_STYLESFOLDER), new File(outputDirectory, "Styles"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String totalReport = Utilities.readFile(reportPath);
        String totalRowTemplate = Utilities.readFile(FilePaths.CUSTOMREPORT2_TEMPLATE_TOTALROWTEMPLATE);

        //iterate through multiple testng xml files (Currently we have only 1)
        for (ISuite indSuite : suites) {
            Map<String, ISuiteResult> indSuiteResults = indSuite.getResults();

            //iterate through test tags in testng xml
            for (Map.Entry<String, ISuiteResult> indTestResultMapEntry : indSuiteResults.entrySet()) {
                ISuiteResult indTestResult = indTestResultMapEntry.getValue();

                List<ITestResult> allTestMethodResults = ReportUtils.getAllTestMethodResults(indTestResult);

                String testTagTemplate = Utilities.readFile(FilePaths.CUSTOMREPORT2_TEMPLATE_TESTTAGTEMPLATE);

                CustomTestTagResult testTagResult = new CustomTestTagResult(indTestResult);
                testTagTemplate = testTagTemplate.replace(htmlReportReplaceStrings.getTestTagName(), testTagResult.getTestName());
                testTagTemplate = testTagTemplate.replace(htmlReportReplaceStrings.getTestTagTimeTaken(), testTagResult.getTestDuration());
                testTagTemplate = testTagTemplate.replace(htmlReportReplaceStrings.getTestTagStatus(), testTagResult.getTestStatus());
                testTagTemplate = testTagTemplate.replace(htmlReportReplaceStrings.getTestTagUniqueName(), testTagResult.getUniqueTestTagName());

                for (ITestResult indTestMethodResult : allTestMethodResults) {

                    CustomTestMethodResult obj = new CustomTestMethodResult(indTestResult, indTestMethodResult);

                    sNo++;
                    String rowTemplate = Utilities.readFile(FilePaths.CUSTOMREPORT2_TEMPLATE_ROWTEMPLATE);

                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodStatusClass(), obj.getMethodRowClass());
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodSno(), String.valueOf(sNo));
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodPackageName(), obj.getTestMethodPackage());
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodClassName(), obj.getTestMethodClass());
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodMethodName(), obj.getTestMethodName());
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodStartTime(), obj.getTestMethodStartTime());
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodTimeTaken(), obj.getTestMethodDuration());
                    String testMethodLogs = "";
                    String screenShotLink = "";
                    testMethodLogs = ReportUtils.prepareLogsPopupHtml(obj);
                    if (obj.getTestMethodStatus() == TestMethodStatus.FAIL) {
                        screenShotLink = "<a href='screenshots/" + obj.getTestMethodUniqueName() + ".png'>screenshot</a>";
                    }
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodLogs(), testMethodLogs);
                    rowTemplate = rowTemplate.replace(htmlReportReplaceStrings.getTestMethodScreenShotLink(), screenShotLink);

                    testTagTemplate = testTagTemplate.replace(htmlReportReplaceStrings.getTestMethodResultRow(), rowTemplate);

                }
                totalReport = totalReport.replace(htmlReportReplaceStrings.getTestTagResult(), testTagTemplate);
            }

            CustomTotalSuiteResultsSummary summary = new CustomTotalSuiteResultsSummary(indSuiteResults);
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalTestMethods(), String.valueOf(summary.getTotalTestMethods()));
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalPassedtestMethods(), String.valueOf(summary.getTotalPassedtestMethods()));
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalFailedTestMethods(), String.valueOf(summary.getTotalFailedTestMethods()));
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalSkippedTestMethods(), String.valueOf(summary.getTotalSkippedTestMethods()));
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalPartialSuccessTestMethods(), String.valueOf(summary.getTotalPartialSuccessTestMethods()));
            totalRowTemplate = totalRowTemplate.replace(htmlReportReplaceStrings.getSummaryTotalDurationSequential(), summary.getTotalDurationSequential());

            totalReport = totalReport.replace(htmlReportReplaceStrings.getTotalSuiteSummary(), totalRowTemplate);
        }

        Utilities.writeFile(reportPath, totalReport);
    }
}