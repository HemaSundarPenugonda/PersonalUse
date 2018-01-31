package com.hs.testDataBeans;

import java.io.File;

public class FilePaths {

    public final static String USERS_DATA;
    public final static String CONFIG_DATA;
    public final static String HTML_REPORT_STRINGS;

    public final static String CUSTOMREPORT2_TEMPLATE_TOTALREPORT;
    public final static String CUSTOMREPORT2_TEMPLATE_SCRIPTSFOLDER;
    public final static String CUSTOMREPORT2_TEMPLATE_STYLESFOLDER;
    public final static String CUSTOMREPORT2_TEMPLATE_TOTALROWTEMPLATE;
    public final static String CUSTOMREPORT2_TEMPLATE_TESTTAGTEMPLATE;
    public final static String CUSTOMREPORT2_TEMPLATE_ROWTEMPLATE;
    public final static String CUSTOMREPORT2_TEMPLATE_POPUP;

    public final static String POST_REQUEST_PRODUCTLIST, POST_REQUEST_PRODUCTS;

    static {
        String mainResourcesFolderPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String customReport2_templateFolder = mainResourcesFolderPath + "htmlTemplates" + File.separator;

        USERS_DATA = mainResourcesFolderPath + "users.yaml";
        CONFIG_DATA = mainResourcesFolderPath + "config.yaml";
        HTML_REPORT_STRINGS = mainResourcesFolderPath + "htmlReportStrings.yaml";

        CUSTOMREPORT2_TEMPLATE_TOTALREPORT = customReport2_templateFolder + "/TotalReport_Template.html";

        CUSTOMREPORT2_TEMPLATE_SCRIPTSFOLDER = customReport2_templateFolder + "Scripts";
        CUSTOMREPORT2_TEMPLATE_STYLESFOLDER = customReport2_templateFolder + "Styles";

        CUSTOMREPORT2_TEMPLATE_TOTALROWTEMPLATE = customReport2_templateFolder + "TotalRowtemplate.html";
        CUSTOMREPORT2_TEMPLATE_TESTTAGTEMPLATE = customReport2_templateFolder + "testTagResult.html";
        CUSTOMREPORT2_TEMPLATE_ROWTEMPLATE = customReport2_templateFolder + "Rowtemplate.html";
        CUSTOMREPORT2_TEMPLATE_POPUP = customReport2_templateFolder + "CellPopup.html";

        POST_REQUEST_PRODUCTLIST = mainResourcesFolderPath + "apiRequests/ProductListRequest.json";
        POST_REQUEST_PRODUCTS = mainResourcesFolderPath + "apiRequests/Products.json";
    }
}
