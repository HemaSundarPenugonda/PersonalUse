package com.hs.poc;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test_Middleware {

    public static void main(String[] args) throws IOException, JSONException {
        writeProductsInfo("0813511783");
        writeProductsInfo("0847223735");
        writeProductsInfo("0937965038");
        writeProductsInfo("0937965001");
        writeProductsInfo("0937965039");
        writeProductsInfo("0916961018");
        writeProductsInfo("0916961015");
        writeProductsInfo("0855194732");
        writeProductsInfo("0971400953");
        writeProductsInfo("0937965027");
        writeProductsInfo("0957590194");



    }

    private static void writeProductsInfo(String msisdn) throws IOException, JSONException {
        String response_BundleUsage = MiddlewareAPIUtils.callGetBundleProfileList(msisdn);

        String fileContent = "";
        fileContent = fileContent + "BundleUsage Response: \n\n";
        fileContent = fileContent + new JSONObject(response_BundleUsage).toString(4);

        Files.write(Paths.get("middleware_" + msisdn+".json"), fileContent.getBytes(), StandardOpenOption.CREATE);
    }
}
