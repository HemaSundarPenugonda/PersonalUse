package com.hs.testDataBeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class TestData {

    private static ConfigDataBean configData;
    private static UsersDataBean usersData;
    private static HtmlReportStringsBean htmlReportStrings;

    public static ConfigDataBean getConfigData() {
        if (configData == null) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                configData = mapper.readValue(new File(FilePaths.CONFIG_DATA), ConfigDataBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configData;
    }

    public static UsersDataBean getUsersData() {
        if (usersData == null) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                usersData = mapper.readValue(new File(FilePaths.USERS_DATA), UsersDataBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return usersData;
    }

    public static HtmlReportStringsBean getHtmlReportStrings() {
        if (htmlReportStrings == null) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                htmlReportStrings = mapper.readValue(new File(FilePaths.HTML_REPORT_STRINGS), HtmlReportStringsBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return htmlReportStrings;
    }

}
