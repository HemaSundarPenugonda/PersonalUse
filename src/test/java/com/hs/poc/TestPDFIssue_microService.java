package com.hs.poc;

import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestPDFIssue_microService {
    static int i;

    public static void main(String[] args) throws IOException, JSONException, InterruptedException {

        for (int j = 0; j < 1000; j++) {
            String s = MicroServiceAPIUtils.callGetInvoicePdf("010120181075000988", "MicroService/download_" + i + ".pdf");
            i++;
            Thread.sleep(30000);
        }


    }
}
