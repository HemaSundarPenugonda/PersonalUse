package com.hs.poc;

import com.hs.apiUtils.RestApiUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MicroServiceAPIUtils {

    //    private static final String URL = "http://dmpapi-dev.trueid.net/iservice-subscriber-dev";
    private static final String URL = "https://dmpapi-alpha.trueid.net/iservice-subscriber-alpha";
    //    private static final String AUTHORIZATION = "Bearer 59a3b924233eaa10411635f4d182a204bce64f615edc68ecb304bb82";
    private static final String AUTHORIZATION = "Bearer 5a17c1404cacebc7897911d6129138cd45d54946a0a7dad3c881c5b5";

    public static String callProductById(String msisdn) throws IOException, JSONException {

        return RestApiUtils.sendingGetRequest(URL + "/product/" + msisdn, AUTHORIZATION);
    }

    public static String callProductDetails(String msisdn) throws IOException, JSONException {

        String productsResponse = callProductById(msisdn);
        JSONObject obj = new JSONObject(productsResponse);
        JSONArray tmhPostpaid;
        try {
            tmhPostpaid = obj.getJSONArray("tmhPostpaid");
        } catch (JSONException e) {
            return "{tmhPostpaid: not found }";

        }
        Object o = tmhPostpaid.get(0);

        Object subscriberId = ((JSONObject) o).get("subscriberId");

        String path = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/microService_productDetails.json";
        String postJsonData = Files.lines(Paths.get(path))
                .collect(Collectors.joining("\n"))
                .replace("${subscriberId}", subscriberId.toString())
                .replace("${msisdn}", msisdn);

        String response = RestApiUtils.sendingPostRequest(URL + "/productDetails", postJsonData, AUTHORIZATION);
        return response;
    }


    public static String callGetInvoicePdf(String invoiceNumber, String fileName) throws IOException, JSONException {

//        return RestApiUtils.sendingGetRequest(URL + "/getInvoicePdf/" + invoiceNumber, AUTHORIZATION);


        java.net.URL url = new URL(URL + "/getInvoicePdf/" + invoiceNumber);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("Authorization", AUTHORIZATION);
        con.setRequestProperty("Content-Type", "application/pdf");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            byte[] buffer = new byte[2048];
            int bytesRead = 0;
            InputStream is = con.getInputStream();
            DataOutputStream os = new DataOutputStream(new FileOutputStream(fileName));
            while((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }

        return "";
    }
}

