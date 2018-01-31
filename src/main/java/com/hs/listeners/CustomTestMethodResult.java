package com.hs.listeners;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.hs.utils.Utilities;

import java.util.List;

public class CustomTestMethodResult {
    private ITestResult currentTestMethodResult;
    private ISuiteResult currentTestResult;

    public CustomTestMethodResult(ISuiteResult currentTestResult, ITestResult currentTestMethodResult) {
        this.currentTestResult = currentTestResult;
        this.currentTestMethodResult = currentTestMethodResult;
    }

    public String getTestName() {
        return currentTestResult.getTestContext().getName();
    }

    public String getTestDuration() {
        return Utilities.timeConversion(currentTestResult.getTestContext().getEndDate().getTime() - currentTestResult.getTestContext().getStartDate().getTime());
    }

    public String getTestMethodPackage() {
        return currentTestMethodResult.getTestClass().getRealClass().getPackage().getName();
    }

    public String getTestMethodClass() {
        return currentTestMethodResult.getTestClass().getRealClass().getSimpleName();
    }

    public String getTestMethodName() {
        return currentTestMethodResult.getMethod().getMethodName();
    }

    public TestMethodStatus getTestMethodStatus() {
        return TestMethodStatus.valueOf(currentTestMethodResult.getStatus());
    }

    public String getTestMethodUniqueName() {
        return getTestMethodPackage().replace(".", "_") + "_" + getTestMethodClass() + "_" + getTestMethodName();
    }

    public String getMethodRowClass(){
        if (getTestMethodStatus() == TestMethodStatus.PASS) {
            return "passedTest";
        } else if (getTestMethodStatus() == TestMethodStatus.FAIL) {
            return "failedTest";
        } else if (getTestMethodStatus() == TestMethodStatus.SKIP) {
            return "skippedTest";
        } else if (getTestMethodStatus() == TestMethodStatus.PARTIALSUCCESS) {
            return "partialSuccessTest";
        }
        return "";
    }

    public String getExceptionName() {
        String exceptionName = "SuccessLogs";
        if (getTestMethodStatus() == TestMethodStatus.FAIL) {
            exceptionName = currentTestMethodResult.getThrowable().getClass().getName();
        }
        return exceptionName;
    }

    public String getStackTrace() {
        String stackTrace = "";
        List<String> reporterLogs = Reporter.getOutput(currentTestMethodResult);
        for (String str : reporterLogs) {
            stackTrace = stackTrace + str + "\n";
        }

        if (getTestMethodStatus() == TestMethodStatus.FAIL) {
            stackTrace = stackTrace + "\n" + StringEscapeUtils.escapeHtml(ExceptionUtils.getFullStackTrace(currentTestMethodResult.getThrowable()));
        }
        return stackTrace;
    }

    public String getTestMethodDuration() {
        return Utilities.timeConversion(currentTestMethodResult.getEndMillis() - currentTestMethodResult.getStartMillis());
    }

    public String getTestMethodStartTime() {
        return Utilities.dateConversion(currentTestMethodResult.getStartMillis());
    }
}

enum TestMethodStatus {
    PASS(1), FAIL(2), SKIP(3), PARTIALSUCCESS(4);

    public int value;
    TestMethodStatus(int i) {
        this.value = i;
    }
    public static TestMethodStatus valueOf(int i){
        TestMethodStatus returnObj = null;
        for (TestMethodStatus obj: TestMethodStatus.values()) {
            if (obj.value == i)
                returnObj = obj;
            else
                continue;
        }
        return returnObj;
    }
}