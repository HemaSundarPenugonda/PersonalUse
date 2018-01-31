package com.hs.poc;

import com.hs.apiUtils.RestApiUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MiddlewareAPIUtils {

//    private static final String URL = "http://172.16.2.199:8080/v1";
    private static final String URL = "http://172.16.3.51:8080/v1";
    private static final String AUTHORIZATION = "Basic dXNlcjE6TUMjcHcwMSEl";

    public static String callGetBundleProfileList(String number) throws IOException, JSONException {
        String getBundledListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/getBundledList.json";
        String getBundledListData = Files.lines(Paths.get(getBundledListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        return RestApiUtils.sendingPostRequest(URL + "/get_bundle_profile_list/", getBundledListData, AUTHORIZATION);

    }

    public static String callGetOrchestratedProductList(String number) throws IOException, JSONException {
        String getOrchestratedProductListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetOrchestratedProductList.json";
        String postJsonData = Files.lines(Paths.get(getOrchestratedProductListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        return RestApiUtils.sendingPostRequest(URL + "/get_orchestrated_product_list/", postJsonData, AUTHORIZATION);
    }


    public static String callGetBillImage(String number) throws IOException, JSONException {
        String getOrchestratedProductListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetBillImage.json";
        String postJsonData = Files.lines(Paths.get(getOrchestratedProductListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        return RestApiUtils.sendingPostRequest(URL + "/get_BillImage/", postJsonData, AUTHORIZATION);
    }

    public static String callGetInvoiceList(String accountID) throws IOException, JSONException {
        String urlString = URL + "/get_invoicelist/" + accountID + "/3";
        return RestApiUtils.sendingGetRequest(urlString);
    }

    public static String callGetCreditLimitInfo(String number) throws IOException, JSONException {
        String getCreditLimitInfoPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetCreditLimitInfo.json";
        String postJsonData = Files.lines(Paths.get(getCreditLimitInfoPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        return RestApiUtils.sendingPostRequest("http://172.16.2.199:8080/v1/get_CreditLimitInfo/", postJsonData, AUTHORIZATION);
    }

















    public static String getAccountID(XSSFSheet sheet, String response) {
        String collect = Arrays.stream(response.split("\n"))
                .map(str -> str.trim())
                .filter(str -> str.startsWith("\"accountId\":"))
                .limit(1)
                .collect(Collectors.joining());
        String accountID = collect.replace("\"", "")
                .replace("accountId: ", "")
                .replace(",", "");
        POIUtilities.writeToCellExcel(sheet, 2, 2, "GetInvoice", true);
        return accountID;
    }

    public static String getCustomerIDFromGetPrimaryKeyListByActiveOrSuspendAPIResult(String response) throws Exception {

        String collect = Arrays.stream(response.split("\n"))
                .map(str -> str.trim())
                .filter(str -> str.startsWith("\"customerId\":"))
                .limit(1)
                .collect(Collectors.joining());
        String customerId = collect.replace("\"", "")
                .replace("customerId: ", "")
                .replace(",", "");
        if (isInteger(customerId)) {
            return customerId;
        } else {
            return "";
        }

    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getProductIDFromGetPrimaryKeyListByActiveOrSuspendAPIResult(String response) throws Exception {

        String collect = Arrays.stream(response.split("\n"))
                .map(str -> str.trim())
                .filter(str -> str.startsWith("\"productId\":"))
                .limit(1)
                .collect(Collectors.joining());
        String productId = collect.replace("\"", "")
                .replace("productId: ", "")
                .replace(",", "");

        if (isInteger(productId)) {
            return productId;
        } else {
            return "";
        }
    }
}
