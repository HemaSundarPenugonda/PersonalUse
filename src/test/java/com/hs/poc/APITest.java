package com.hs.poc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.apiTestBeans.BillDetailsResponse;
import com.hs.apiTestBeans.IndividualBillDetails;
import com.hs.apiTestBeans.ProductListResponse;
import com.hs.apiUtils.ApiUrl;
import com.hs.apiUtils.RestApiUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Paths;
import java.util.HashMap;

public class APITest {
    public static void main(String[] args) throws Exception {

//        String productList = RestApiUtils.sendingPostRequest("http://dmpapi-dev.trueid.net/iservice-subscriber-dev/productList", Paths.get("/Users/hemasundar/xebia/projects/mck/iservice-app-automation/src/main/resources/apiRequests/ProductListRequest.json"));
//        ObjectMapper mapper = new ObjectMapper();
//        ProductListResponse productListResponse = mapper.readValue(productList, ProductListResponse.class);
//        System.out.println(productListResponse.ccbsList[1].arBalance);


//        String billsDetailsResponse = RestApiUtils.sendingGetRequest("http://dmpapi-dev.trueid.net/iservice-subscriber-dev/invoices?accountNo=10088418");
//        JSONArray jsonArray = new JSONObject(billsDetailsResponse).getJSONArray("10088418");
//        IndividualBillDetails[] test = new IndividualBillDetails[10];
//        for (int i = 0; i<jsonArray.length();i++) {
//            test[i] = mapper.readValue(jsonArray.get(i).toString(), IndividualBillDetails.class);
//
//        }
//        BillDetailsResponse BillDetailsResponse = new BillDetailsResponse();
//        BillDetailsResponse.billDetailsArray = test;
//
//        System.out.println(productListResponse.ccbsList[1].arBalance);


        ObjectMapper mapper = new ObjectMapper();

        String billsDetailsResponse = RestApiUtils.sendingGetRequest(ApiUrl.INVOICE.replace("${accountNo}", "10088418"));

        HashMap hashMap = mapper.readValue(billsDetailsResponse, HashMap.class);
        System.out.println(hashMap);
    }
}
