package com.hs.apiUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.apiTestBeans.BillDetailsResponse;
import com.hs.apiTestBeans.BillDetailsResponse;
import com.hs.apiTestBeans.IndividualBillDetails;
import com.hs.apiTestBeans.ProductListResponse;
import com.hs.testDataBeans.FilePaths;
import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApiResults {
    public static ProductListResponse getProductListResponse(String userName, String thaiID) throws IOException {

        String request = new Scanner(Paths.get(FilePaths.POST_REQUEST_PRODUCTLIST))
                .useDelimiter("\\Z")
                .next()
                .replace("${userName}", userName)
                .replace("${thaiID}", thaiID);

        return getGenericPostResponse(ApiUrl.PRODUCT_LIST, request, ProductListResponse.class);
    }

    public static BillDetailsResponse getInvoicesResponse(String accountNo) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();

        String billsDetailsResponse = RestApiUtils.sendingGetRequest(ApiUrl.INVOICE.replace("${accountNo}", accountNo));

        HashMap<String, String> hashMap = mapper.readValue(billsDetailsResponse, HashMap.class);

        Map<String, IndividualBillDetails> result = new HashMap<>();
        for (Map.Entry<String, String> item : hashMap.entrySet()) {
            String key = item.getKey();
            String value = item.getValue();
            result.put(key, mapper.readValue(value, IndividualBillDetails.class));
        }
        BillDetailsResponse billDetailsResponse = new BillDetailsResponse();
        billDetailsResponse.setBillDetailsArray(result);

        return billDetailsResponse;
    }

    private static <T>T getGenericPostResponse(String url, String request, Class<T> T) throws IOException {

        String productList = RestApiUtils.sendingPostRequest(url, request);
        return new ObjectMapper().readValue(productList, T);

    }

    private static <T>T getGenericGetResponse(String url, Class<T> T) throws IOException {

        String productList = RestApiUtils.sendingGetRequest(url);
        return new ObjectMapper().readValue(productList, T);

    }
}
