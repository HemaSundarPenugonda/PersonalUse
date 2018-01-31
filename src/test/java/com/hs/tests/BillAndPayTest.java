package com.hs.tests;

import com.hs.apiTestBeans.BillDetailsResponse;
import com.hs.apiTestBeans.ProductListResponse;
import com.hs.apiUtils.ApiResults;
import com.hs.testUtils.CustomAssertions;
import com.hs.pages.BillsAndUsagePage;
import com.hs.pages.LoginPageActions;
import com.hs.testDataBeans.TestData;
import com.hs.testDataBeans.UsersDataBean;
import com.hs.utils.ElementUtils;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillAndPayTest extends BaseTest {
    private LoginPageActions loginPage;

    @Test
    public void testBillAndPay_smartPlanLabels() throws Exception {
        loginPage = new LoginPageActions(driver);

        UsersDataBean.User currentUser = TestData.getUsersData().getUser3();
        String username = currentUser.getUserName();
        String password = currentUser.getPassWord();

        navigateToLoginPage();

        loginPage.loginIntoTrueApplication(username, password);

        testBillsAndUsage(currentUser, false);

    }

    @Test
    public void testBillAndPay_sharePlanLabels() throws Exception {
        loginPage = new LoginPageActions(driver);

        UsersDataBean.User currentUser = TestData.getUsersData().getUser3();
        String username = currentUser.getUserName();
        String password = currentUser.getPassWord();

        navigateToLoginPage();

        loginPage.loginIntoTrueApplication(username, password);

        testBillsAndUsage(currentUser, true);

    }

    @Test
    public void clickBillAndPay() throws Exception {
        loginPage = new LoginPageActions(driver);

        UsersDataBean.User currentUser = TestData.getUsersData().getUser3();
        String username = currentUser.getUserName();
        String password = currentUser.getPassWord();

        navigateToLoginPage();

        loginPage.loginIntoTrueApplication(username, password);

        clickBillsAndUsageTabs(currentUser, false);

    }

    private void testBillsAndUsage(UsersDataBean.User currentUser, boolean isSharePlan) throws IOException, JSONException {
        BillsAndUsagePage billAndPayPage = new BillsAndUsagePage(driver);

        ProductListResponse productListResponse = ApiResults.getProductListResponse(currentUser.getUserName(), currentUser.getThaiID());

        CustomAssertions.assertText(billAndPayPage.getBillingSummarySectionHeader(), "Billing Summary", "Verified section header as");
        billAndPayPage.clickExpandMibileBillDetailsIcon();
        CustomAssertions.assertText(billAndPayPage.getCurrentPlanNameText(), "4G Super Smart 899", "Verified current plan name as");
        CustomAssertions.assertText(billAndPayPage.getExtraPackagesText(), "(4 Extra Packages)", "Verified extra package text as");
        CustomAssertions.assertText(billAndPayPage.getCurrentUsageTabText(), "Current Usage \uE901", "Verified current usage tab text as");
        CustomAssertions.assertText(billAndPayPage.getBillDetailsTabext(), "Bill Details", "Verified bill details tab text as");
//        System.out.println(billAndPayPage.getBillDetails_ViewPaymentHistoryLinkText());
        Assert.assertEquals(billAndPayPage.getCurrentUsage_talkText(), "Talk 50 from 80 min");
        Assert.assertEquals(billAndPayPage.getCurrentUsage_dataText(), "Data 20 from 100 GB");


        ElementUtils.shortSwipeUp(driver);
        Assert.assertEquals(billAndPayPage.getCurrentUsage_buyExtraPackPopuUpText(), "Buy extra price packs!");
        Assert.assertEquals(billAndPayPage.getCurrentUsage_seeOtherExtraPackagesText(), "See other extra packages");
        if (isSharePlan)
            Assert.assertEquals(billAndPayPage.getCurrentUsage_sharedNumbersLinkText(), "Shared numbers 2 \uE919");


        billAndPayPage.clickBillDetailsTab();


        String accountId = (productListResponse.getCcbsList())[1].getAccountId();
        BillDetailsResponse invoicesResponse = ApiResults.getInvoicesResponse(accountId);

        Assert.assertEquals(billAndPayPage.getBillDetails_pendingBill1Text(), "฿" + invoicesResponse.getBillDetailsByAccoutID(accountId).getUnpaidAmount());

        billAndPayPage.clickSearch_CurrentPlanDetailsIcon();

        Assert.assertEquals(billAndPayPage.getPackageDetailsTabText(), "Package Detail \uE901");

        Assert.assertEquals(billAndPayPage.getPackageDetails_voiceLabelText(), "Voice");
        Assert.assertEquals(billAndPayPage.getPackageDetails_dataLabelText(), "Data");
        Assert.assertEquals(billAndPayPage.getPackageDetails_wifiLabelText(), "Free WIFI");
        Assert.assertEquals(billAndPayPage.getPackageDetails_smsMmsLabelText(), "SMS/MMS");
        billAndPayPage.clickExtraPackageTab();
        Assert.assertEquals(billAndPayPage.getExtraPackage_activeSectionText(), "Active");
        Assert.assertEquals(billAndPayPage.getExtraPackage_inActiveSectionText(), "Inactive");
    }

    private void clickBillsAndUsageTabs(UsersDataBean.User currentUser, boolean isSharePlan) throws IOException, JSONException {
        BillsAndUsagePage billAndPayPage = new BillsAndUsagePage(driver);


//        billAndPayPage.clickExpandMibileBillDetailsIcon();

        billAndPayPage.clickBillDetailsTab();


//        billAndPayPage.clickSearch_CurrentPlanDetailsIcon();
    }
}
