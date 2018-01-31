package com.hs.poc;

import com.hs.apiUtils.RestApiUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) throws Exception {

        XSSFWorkbook excel = POIUtilities.createExcel();

        writeEntireSheet("880042159INF", excel, "TrueOnline_");
        writeEntireSheet("9630000095", excel, "TrueOnline_");
        writeEntireSheet("9630000627", excel, "TrueOnline_");

        writeEntireSheet("0090403780", excel, "TrueVision_");
        writeEntireSheet("0090388600", excel, "TrueVision_");
        writeEntireSheet("0090421630", excel, "TrueVision_");
        writeEntireSheet("0090378264", excel, "TrueVision_");

//        need to check
        writeEntireSheet("0957590194", excel, "TrueConvergence_Mobile");
        writeEntireSheet("9101086485", excel, "TrueConvergence_TOL");
        writeEntireSheet("0090428137", excel, "TrueConvergence_TVS");

        writeEntireSheet("0961160020", excel, "TrueConvergence_Mobile");
        writeEntireSheet("NF0041561I", excel, "TrueConvergence_TOL_");
        writeEntireSheet("0090424233", excel, "TrueConvergence_TVS_");

        writeEntireSheet("9101086557", excel, "TrueConvergence_TOL");
        writeEntireSheet("0090431388", excel, "TrueConvergence_TVS_");

        writeEntireSheet("0916961014", excel, "SharePlane_");

        writeEntireSheet("0813511783", excel, "TrueMove_Post_Norm_");
        writeEntireSheet("0847223735", excel, "TrueMove_Post_Norm_");
        writeEntireSheet("0937965038", excel, "TrueMove_Post_Corp_");
        writeEntireSheet("0942188600", excel, "TrueMove_Post_Norm_");
        writeEntireSheet("0937965039", excel, "TrueMove_Post_Corp_");
        writeEntireSheet("0910393441", excel, "TrueMove_Pre_Pers_");
        writeEntireSheet("0909184684", excel, "TrueMove_Pre_Pers_");
        writeEntireSheet("0916961018", excel, "TrueMove_Post_Multi_");

        POIUtilities.writeToExcel("/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/MyFirstExcel.xlsx", excel);

    }

    @Test
    public void main1() throws Exception {


        XSSFWorkbook excel = POIUtilities.createExcel();

        writeEntireSheet("0813511783", excel, "TMH_PostPaid");
        writeEntireSheet("0847223735", excel, "TMH_PostPaid");
        writeEntireSheet("0937965038", excel, "TMH_PostPaid");
        writeEntireSheet("0942188600", excel, "TMH_PostPaid");
        writeEntireSheet("0937965039", excel, "TMH_PostPaid");
        writeEntireSheet("0910393441", excel, "TMH_PrePaid");
        writeEntireSheet("0909184684", excel, "TMH_PrePaid");
        writeEntireSheet("0916961018", excel, "TMH_PostPaid");
        writeEntireSheet("0916961014", excel, "TMH_PostPaid");

        POIUtilities.writeToExcel("/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/MyFirstExcel.xlsx", excel);


    }

    /*    private static void writeEntireSheet(String number, XSSFWorkbook excel, String sheetNamePrefix) throws Exception {
            XSSFSheet sheet = POIUtilities.createNewSheetExcel(excel, sheetNamePrefix + number);

            setHeaderColumn(sheet);

            String response = writeGetOrchestratedProductList(number, sheet);

            String accountID = getAccountID(sheet, response);

            if (!accountID.equalsIgnoreCase("")) {
                writeGetInvoice(sheet, accountID);
            }

            writeGetBundledList(number, sheet);

            POIUtilities.setAutoAdjustColumns(sheet);
        }*/
    private static void writeEntireSheet(String number, XSSFWorkbook excel, String sheetNamePrefix) throws Exception {
        XSSFSheet sheet = POIUtilities.createNewSheetExcel(excel, sheetNamePrefix + number);

        setHeaderColumn(sheet);

        writeGetCreditLimitInfo(number, sheet);

        POIUtilities.writeToCellExcel(sheet, 2, 2, "GetCallDetailList", true);
        String cycleInfo = getBillCycle(number);
        if (!cycleInfo.equalsIgnoreCase("")) {
            writeGetCallDetailList(number, cycleInfo, sheet);
        }

        String response = writeGetPrimaryKeyListByActiveOrSuspend(sheet, number);

        POIUtilities.writeToCellExcel(sheet, 2, 4, "GetCustomerInfo", true);
        String customerID = MiddlewareAPIUtils.getCustomerIDFromGetPrimaryKeyListByActiveOrSuspendAPIResult(response);
        if (!customerID.equalsIgnoreCase("")) {
            writeGetCustomerInfo(sheet, customerID);
        }

        POIUtilities.writeToCellExcel(sheet, 2, 5, "GetPrepaidProfileInfo", true);
        String productId = MiddlewareAPIUtils.getProductIDFromGetPrimaryKeyListByActiveOrSuspendAPIResult(response);
        if (!productId.equalsIgnoreCase("")) {
            writeGetPrepaidProfileInfo(sheet, productId);
        }


        POIUtilities.setAutoAdjustColumns(sheet);
    }



    private static void writeGetBundledList(String number, XSSFSheet sheet) throws Exception {
        String getBundledListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/getBundledList.json";
        String getBundledListData = Files.lines(Paths.get(getBundledListPath)).collect(Collectors.joining("\n")).replace("${number}", number);

        String getBundledListResponse = MiddlewareAPIUtils.callGetBundleProfileList(number);

        POIUtilities.writeToCellExcel(sheet, 2, 3, "GetBundledList", true);
        POIUtilities.writeToCellExcel(sheet, 3, 3, "8th Nov, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 3, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 3, "http://172.16.2.199:8080/v1/get_bundle_profile_list/");
        POIUtilities.writeToCellExcel(sheet, 7, 3, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 8, 3, getBundledListData);
        POIUtilities.writeToCellExcel(sheet, 9, 3, getBundledListResponse);
    }

    private static String writeGetOrchestratedProductList(String number, XSSFSheet sheet) throws Exception {
        String getOrchestratedProductListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetOrchestratedProductList.json";
        String postJsonData = Files.lines(Paths.get(getOrchestratedProductListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        String response = MiddlewareAPIUtils.callGetOrchestratedProductList(number);

        POIUtilities.writeToCellExcel(sheet, 1, 1, number, true);
        POIUtilities.writeToCellExcel(sheet, 2, 1, "GetOrchestratedProductList", true);
        POIUtilities.writeToCellExcel(sheet, 3, 1, "8th Nov, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 1, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 1, "http://172.16.2.199:8080/v1/get_orchestrated_product_list/");
        POIUtilities.writeToCellExcel(sheet, 7, 1, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 8, 1, postJsonData);
        POIUtilities.writeToCellExcel(sheet, 9, 1, response);
        return response;
    }

    private static void writeGetInvoice(XSSFSheet sheet, String accountID) throws Exception {
        String urlString = "http://172.16.2.199:8080/v1/get_invoicelist/" + accountID + "/3";

        String s = MiddlewareAPIUtils.callGetInvoiceList(accountID);

        POIUtilities.writeToCellExcel(sheet, 3, 2, "8th Nov, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 2, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 2, urlString);
        POIUtilities.writeToCellExcel(sheet, 7, 2, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 9, 2, s);
    }

    private static void setHeaderColumn(XSSFSheet sheet) {
        POIUtilities.writeToCellExcel(sheet, 1, 0, "MSISDN", true);
        POIUtilities.writeToCellExcel(sheet, 2, 0, "API Name", true);
        POIUtilities.writeToCellExcel(sheet, 3, 0, "Test Performed Date", true);
        POIUtilities.writeToCellExcel(sheet, 4, 0, "Tested By ", true);

        POIUtilities.writeToCellExcel(sheet, 6, 0, "Request URL", true);
        POIUtilities.writeToCellExcel(sheet, 7, 0, "Request Headers", true);
        POIUtilities.writeToCellExcel(sheet, 8, 0, "Request body", true);
        POIUtilities.writeToCellExcel(sheet, 9, 0, "Response recieved", true);
    }

    private static String writeGetCreditLimitInfo(String number, XSSFSheet sheet) throws Exception {
        String getCreditLimitInfoPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetCreditLimitInfo.json";
        String postJsonData = Files.lines(Paths.get(getCreditLimitInfoPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        String response = MiddlewareAPIUtils.callGetCreditLimitInfo(number);

        POIUtilities.writeToCellExcel(sheet, 1, 1, number, true);
        POIUtilities.writeToCellExcel(sheet, 2, 1, "getCreditLimitInfo", true);
        POIUtilities.writeToCellExcel(sheet, 3, 1, "8th Dec, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 1, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 1, "http://172.16.2.199:8080/v1/get_CreditLimitInfo/");
        POIUtilities.writeToCellExcel(sheet, 7, 1, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 8, 1, postJsonData);
        POIUtilities.writeToCellExcel(sheet, 9, 1, response);
        return response;
    }

    private static String writeGetCallDetailList(String number, String cycleInfo, XSSFSheet sheet) throws Exception {
        String getCallDetailListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/GetCallDetailList.json";
        String postJsonData = Files.lines(Paths.get(getCallDetailListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number)
                .replace("${date}", cycleInfo)
                .replace("${month}", cycleInfo)
                .replace("${year}", cycleInfo);

        String response = RestApiUtils.sendingPostRequest("http://172.16.2.199:8080/v1/get_CallDetailList/", postJsonData);

        POIUtilities.writeToCellExcel(sheet, 1, 2, number, true);
        POIUtilities.writeToCellExcel(sheet, 2, 2, "GetCallDetailList", true);
        POIUtilities.writeToCellExcel(sheet, 3, 2, "8th Dec, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 2, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 2, "http://172.16.2.199:8080/v1/get_CallDetailList/");
        POIUtilities.writeToCellExcel(sheet, 7, 2, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 8, 2, postJsonData);
        POIUtilities.writeToCellExcel(sheet, 9, 2, response);
        return response;
    }

    private static String writeGetPrimaryKeyListByActiveOrSuspend(XSSFSheet sheet, String number) throws Exception {
        String urlString = "http://172.16.2.199:8080/v1/get_PrimaryKeyListByActiveOrSuspend/" + number + "/";
        String response = RestApiUtils.sendingGetRequest(urlString);

        POIUtilities.writeToCellExcel(sheet, 2, 3, "GetPrimaryKeyListByActiveOrSuspend", true);
        POIUtilities.writeToCellExcel(sheet, 3, 3, "8th Dec, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 3, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 3, urlString);
        POIUtilities.writeToCellExcel(sheet, 7, 3, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 9, 3, response);

        return response;
    }

    private static void writeGetCustomerInfo(XSSFSheet sheet, String customerID) throws Exception {
        String urlString = "http://172.16.2.199:8080/v1/get_CustomerInfo/" + customerID + "/";
        String response = RestApiUtils.sendingGetRequest(urlString);

        POIUtilities.writeToCellExcel(sheet, 3, 4, "8th Dec, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 4, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 4, urlString);
        POIUtilities.writeToCellExcel(sheet, 7, 4, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 9, 4, response);
    }

    private static void writeGetPrepaidProfileInfo(XSSFSheet sheet, String productID) throws Exception {
        String urlString = "http://172.16.2.199:8080/v1/get_PrepaidProfileInfo/" + productID + "/";
        String response = RestApiUtils.sendingGetRequest(urlString);

        POIUtilities.writeToCellExcel(sheet, 3, 5, "8th Dec, 2017");
        POIUtilities.writeToCellExcel(sheet, 4, 5, "HemaSundar");
        POIUtilities.writeToCellExcel(sheet, 6, 5, urlString);
        POIUtilities.writeToCellExcel(sheet, 7, 5, "Authorization: Basic dXNlcjE6TUMjcHcwMSEl");
        POIUtilities.writeToCellExcel(sheet, 9, 5, response);
    }

    private static String getBillCycle(String number) throws Exception {
        String getOrchestratedProductListPath = "/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/test/java/com/mckinsey/iService/poc/getBundleProfileList.json";
        String postJsonData = Files.lines(Paths.get(getOrchestratedProductListPath))
                .collect(Collectors.joining("\n"))
                .replace("${number}", number);

        String response = RestApiUtils.sendingPostRequest("http://172.16.2.199:8080/v1/get_bundle_profile_list/", postJsonData);
        System.out.println(response);
        String collect = Arrays.stream(response.split("\n"))
                .map(str -> str.trim())
                .filter(str -> str.startsWith("\"cycleInfo\":"))
                .limit(1)
                .collect(Collectors.joining());
        String cycleInfo = collect.replace("\"", "")
                .replace("cycleInfo: ", "")
                .replace(",", "");
        return cycleInfo;

    }

}
