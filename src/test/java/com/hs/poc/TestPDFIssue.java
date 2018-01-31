package com.hs.poc;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestPDFIssue {

    static int i = 1;

    public static void main(String[] args) throws IOException, JSONException, InterruptedException {

        for (int j = 0; j < 1000; j++) {

            String s = MiddlewareAPIUtils.callGetBillImage("010120181075000988");
            JSONObject jsonObject = new JSONObject(s);
            String biteArray = ((JSONObject) jsonObject.get("billImageInfo")).get("fileBytesArray").toString();

            if (biteArray.startsWith("JVBERi0xL")) {
                Files.write(Paths.get("Screens/billImage_" + i + "_PASS.json"), s.getBytes());
            } else {
                Files.write(Paths.get("Screens/billImage_" + i + "_FAIL.json"), s.getBytes());
            }
            i++;
            Thread.sleep(30000);

        }

    }
}
