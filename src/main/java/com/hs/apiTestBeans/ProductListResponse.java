package com.hs.apiTestBeans;

public class ProductListResponse {
    private IndividualProduct[] ccbsList;
    private IndividualProduct[] iccList;
    private IndividualProduct[] trueList;
    private IndividualProduct[] prepayList;

    public IndividualProduct[] getCcbsList() {
        return ccbsList;
    }

    public void setCcbsList(IndividualProduct[] ccbsList) {
        this.ccbsList = ccbsList;
    }

    public IndividualProduct[] getIccList() {
        return iccList;
    }

    public void setIccList(IndividualProduct[] iccList) {
        this.iccList = iccList;
    }

    public IndividualProduct[] getTrueList() {
        return trueList;
    }

    public void setTrueList(IndividualProduct[] trueList) {
        this.trueList = trueList;
    }

    public IndividualProduct[] getPrepayList() {
        return prepayList;
    }

    public void setPrepayList(IndividualProduct[] prepayList) {
        this.prepayList = prepayList;
    }
}
