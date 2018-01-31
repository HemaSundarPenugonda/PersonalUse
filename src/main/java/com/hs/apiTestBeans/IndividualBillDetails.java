package com.hs.apiTestBeans;

public class IndividualBillDetails {
    private String invoiceNo;
    private String dueDate;
    private String billAmount;
    private String unpaidAmount;
    private String invoiceStatus;
    private String invoiceCycle;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceCycle() {
        return invoiceCycle;
    }

    public void setInvoiceCycle(String invoiceCycle) {
        this.invoiceCycle = invoiceCycle;
    }
}
