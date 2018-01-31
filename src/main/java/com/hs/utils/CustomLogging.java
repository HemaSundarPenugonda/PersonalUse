package com.hs.utils;

import org.testng.Reporter;

public class CustomLogging {
    public static void writeToReport(String prefix, String testData){
        Reporter.log(prefix + " <span class='testdata'>"+testData+"</span>");
    }

    public static void writeToReport(String prefix){
        Reporter.log(prefix );
    }

}
