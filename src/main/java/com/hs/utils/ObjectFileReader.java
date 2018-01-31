package com.hs.utils;


import com.hs.testDataBeans.TestData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class reads the PageObjectRepository text files. Uses buffer reader.
 */
public class ObjectFileReader {


    public static String[] getELementFromFile(String pageName, String elementName) {
        String device = setTier();
        String platform = setPlatform();
        String specFilePath = setSpecFilePath(pageName);

        return getElement(specFilePath, elementName);
    }

    public static String setSpecFilePath(String pageName) {
        return "src/main/resources/pageObjects/Mobile" + File.separator + TestData.getConfigData().getDeviceType().toUpperCase() + File.separator + pageName + ".spec";

    }

    private static Stream<String[]> getSpecFileStream(String specFilePath) {
        try {
            return Files.lines(Paths.get(specFilePath))
                    .filter((str) -> !str.startsWith("=="))
                    .filter((str) -> !str.startsWith("#"))
                    .filter((str) -> !str.trim().equalsIgnoreCase(""))
                    .filter((str) -> !str.startsWith("Page Title:"))
                    .map(str -> str.replaceAll("[\\s]+", " "))
                    .map(str -> str.split(" ", 3));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String[] getElement(String specFilePath, String elementName) {
        return getSpecFileStream(specFilePath)
                .filter(str -> str[0].equalsIgnoreCase(elementName))
                .findFirst()
                .get();
    }

    private static String setTier() {
        switch (CommonEnums.DeviceType.valueOf(TestData.getConfigData().getDeviceType().toUpperCase())) {
            case ANDROID:
                return "ANDROID";
            case IOS:
                return "IOS";
            default:
                return "IOS";
        }
    }

    private static String setPlatform() {
        if (TestData.getConfigData().getBrowser().equalsIgnoreCase("mobile"))
            return "Mobile";
        else
            return "Desktop";

    }
}
