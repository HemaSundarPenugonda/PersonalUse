package com.hs.apiUtils;

import com.hs.testDataBeans.TestData;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RestApiUtils {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static String sendingGetRequest(String urlString) throws IOException {

//        return sendingGetRequest(urlString, "Bearer 59a3b924233eaa10411635f4d182a204bce64f615edc68ecb304bb82");
//        return sendingGetRequest(urlString, "Basic dXNlcjE6TUMjcHcwMSEl");
        return sendingGetRequest(urlString, TestData.getConfigData().getAuthorization());

    }

    public static String sendingGetRequest(String urlString, String authorization) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Authorization", authorization);
        con.setRequestProperty("Content-Type", "application/pdf");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            try(Scanner s = new Scanner(con.getInputStream())) {
             return s.useDelimiter("\\Z").next();
            }


            /*BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output + "\n");
            }
            in.close();

            return response.toString();*/
        } else {
            return "{request failed: " + responseCode + "}";
        }
    }

    public static String sendingPostRequest(String url, Path postDataFilePath) throws IOException {

        String postJsonData = Files.lines(postDataFilePath).collect(Collectors.joining("\n"));
        return sendingPostRequest(url, postJsonData);
    }

    public static String sendingPostRequest(String url, String postDataFileData, String authorization) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", authorization);

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postDataFileData);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output + "\n");
        }
        in.close();
        return response.toString();
    }

    public static String sendingPostRequest(String url, String postDataFileData) throws IOException {

//        return sendingPostRequest(url, postDataFileData, "Bearer 59a3b924233eaa10411635f4d182a204bce64f615edc68ecb304bb82");
//        return sendingPostRequest(url, postDataFileData, "Basic dXNlcjE6TUMjcHcwMSEl");
        return sendingPostRequest(url, postDataFileData, TestData.getConfigData().getAuthorization());
    }
}