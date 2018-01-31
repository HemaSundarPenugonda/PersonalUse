package com.hs.testUtils;

import com.hs.utils.CustomLogging;
import org.testng.Assert;

public class CustomAssertions {
    public static void assertText(String exp, String act, String logPreFix){
        Assert.assertEquals(exp, act);
        CustomLogging.writeToReport(logPreFix, exp);
    }
}
