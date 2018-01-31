package com.hs.utils;

import com.hs.testDataBeans.TestData;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Utilities {

    public static String timeConversion(long milliSeconds) {

        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;
        final int MIILLIS_IN_A_SEC = 1000;

        long seconds = milliSeconds/MIILLIS_IN_A_SEC;
        int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
        seconds -= minutes * SECONDS_IN_A_MINUTE;

        int hours = minutes / MINUTES_IN_AN_HOUR;
        minutes -= hours * MINUTES_IN_AN_HOUR;

        return hours + ":" + minutes + ":" + (int)seconds;
    }

    public static String dateConversion(long unixTimeStamp) {
        return new Date(unixTimeStamp).toString();
    }

    public static String readFile(String path) {
        return readFile(new File(path));
    }

    public static String readFile(File file) {
        String content = "";
        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void writeFile(String filePath, String content) {
        writeFile(new File(filePath), content);
    }

    public static void writeFile(File file, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getEffectiveConfig(String keyValue, String configFileValue) {
        String property = System.getProperty(keyValue);
        if (property != null) {
            if (!property.equalsIgnoreCase("")) {
                return property;
            }
        }
        return configFileValue;
    }

    public static CommonEnums.DeviceType getDeviceOS() {
        String deviceType = TestData.getConfigData().getDeviceType().toUpperCase();
        return CommonEnums.DeviceType.valueOf(deviceType);

    }

}
