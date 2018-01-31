package com.hs.apiTestBeans;

import java.util.Map;

public class BillDetailsResponse {
    private Map<String, IndividualBillDetails> billDetailsArray;

    public Map<String, IndividualBillDetails> getBillDetailsArray() {
        return billDetailsArray;
    }

    public void setBillDetailsArray(Map<String, IndividualBillDetails> billDetailsArray) {
        this.billDetailsArray = billDetailsArray;
    }

    public IndividualBillDetails getBillDetailsByAccoutID(String accountID) {
        return getBillDetailsArray().get(accountID);
    }
}

