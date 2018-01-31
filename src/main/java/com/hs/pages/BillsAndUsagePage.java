package com.hs.pages;

import com.hs.init.BasePage;
import com.hs.utils.ElementUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BillsAndUsagePage extends BasePage {
	public final static String PAGE_NAME;
	static {
		PAGE_NAME = "Bill And Usage Page";
	}

	public BillsAndUsagePage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	protected By expandMibileBillDetails = ElementUtils.getLocator(PAGE_NAME, "expandMibileBillDetails");
	protected By billingSummarySectionHeader = ElementUtils.getLocator(PAGE_NAME, "billingSummarySectionHeader");
	protected By currentPlanName = ElementUtils.getLocator(PAGE_NAME, "currentPlanName");
	protected By extraPackagesText = ElementUtils.getLocator(PAGE_NAME, "extraPackagesText");
	protected By currentUsageTab = ElementUtils.getLocator(PAGE_NAME, "currentUsageTab");
	protected By billDetailsTab = ElementUtils.getLocator(PAGE_NAME, "billDetailsTab");
	protected By billDetails_ViewPaymentHistoryLink = ElementUtils.getLocator(PAGE_NAME, "billDetails_ViewPaymentHistoryLink");
	protected By currentUsage_talk = ElementUtils.getLocator(PAGE_NAME, "currentUsage_talk");
	protected By currentUsage_data = ElementUtils.getLocator(PAGE_NAME, "currentUsage_data");
	protected By currentUsage_buyExtraPackPopuUpHeader = ElementUtils.getLocator(PAGE_NAME, "currentUsage_buyExtraPackPopuUpHeader");
	protected By currentUsage_seeOtherExtraPackages = ElementUtils.getLocator(PAGE_NAME, "currentUsage_seeOtherExtraPackages");
	protected By currentUsage_sharedNumbersLink = ElementUtils.getLocator(PAGE_NAME, "currentUsage_sharedNumbersLink");
	protected By search_CurrentPlanDetailsIcon = ElementUtils.getLocator(PAGE_NAME, "search_CurrentPlanDetailsIcon");
	protected By packageDetailsTab = ElementUtils.getLocator(PAGE_NAME, "packageDetailsTab");
	protected By packageDetails_voiceLabel = ElementUtils.getLocator(PAGE_NAME, "packageDetails_voiceLabel");
	protected By packageDetails_dataLabel = ElementUtils.getLocator(PAGE_NAME, "packageDetails_dataLabel");
	protected By packageDetails_wifiLabel = ElementUtils.getLocator(PAGE_NAME, "packageDetails_wifiLabel");
	protected By packageDetails_smsMmsLabel = ElementUtils.getLocator(PAGE_NAME, "packageDetails_smsMmsLabel");
	protected By extraPackageTab = ElementUtils.getLocator(PAGE_NAME, "extraPackageTab");
	protected By extraPackage_activeSection = ElementUtils.getLocator(PAGE_NAME, "extraPackage_activeSection");
	protected By extraPackage_inActiveSection = ElementUtils.getLocator(PAGE_NAME, "extraPackage_inActiveSection");
	protected By billDetails_pendingBill1 = ElementUtils.getLocator(PAGE_NAME, "billDetails_pendingBill1");

	public String getBillingSummarySectionHeader(){
		return ElementUtils.getText(driver, billingSummarySectionHeader);
	}

	public String getCurrentPlanNameText() {
		return ElementUtils.getText(driver, currentPlanName);
	}

	public String getExtraPackagesText() {
		return ElementUtils.getText(driver, extraPackagesText);
	}

	public String getCurrentUsageTabText() {
		return ElementUtils.getText(driver, currentUsageTab);
	}

	public String getBillDetailsTabext() {
		return ElementUtils.getText(driver, billDetailsTab);
	}

	public void clickBillDetailsTab() {
		ElementUtils.clickObject(driver, billDetailsTab);

		LaunchPageActions launchPage = new LaunchPageActions(driver);
		launchPage.waitForProgressBar();
	}

	public String getBillDetails_ViewPaymentHistoryLinkText() {
		return ElementUtils.getText(driver, billDetails_ViewPaymentHistoryLink);
	}

	public String getCurrentUsage_talkText() {
		return ElementUtils.getText(driver, currentUsage_talk);
	}

	public String getCurrentUsage_dataText() {
		return ElementUtils.getText(driver, currentUsage_data);
	}

	public String getCurrentUsage_buyExtraPackPopuUpText() {
		return ElementUtils.getText(driver, currentUsage_buyExtraPackPopuUpHeader);
	}

	public String getCurrentUsage_seeOtherExtraPackagesText() {
		return ElementUtils.getText(driver, currentUsage_seeOtherExtraPackages);
	}

	public String getCurrentUsage_sharedNumbersLinkText() {
		return ElementUtils.getText(driver, currentUsage_sharedNumbersLink);
	}

	public void clickSearch_CurrentPlanDetailsIcon() {
		ElementUtils.clickObject(driver, search_CurrentPlanDetailsIcon);
	}

	public void clickExpandMibileBillDetailsIcon(){
		ElementUtils.clickObject(driver, expandMibileBillDetails);
	}

	public String getPackageDetailsTabText(){
		return ElementUtils.getText(driver, packageDetailsTab);
	}

	public String getPackageDetails_voiceLabelText(){
		return ElementUtils.getText(driver, packageDetails_voiceLabel);
	}

	public String getPackageDetails_dataLabelText(){
		return ElementUtils.getText(driver, packageDetails_dataLabel);
	}

	public String getPackageDetails_wifiLabelText(){
		return ElementUtils.getText(driver, packageDetails_wifiLabel);
	}

	public String getPackageDetails_smsMmsLabelText(){
		return ElementUtils.getText(driver, packageDetails_smsMmsLabel);
	}

	public void clickExtraPackageTab(){
		ElementUtils.clickObject(driver, extraPackageTab);
	}

	public String getExtraPackage_activeSectionText(){
		return ElementUtils.getText(driver, extraPackage_activeSection);
	}
	public String getBillDetails_pendingBill1Text(){
		return ElementUtils.getText(driver, billDetails_pendingBill1).replace(" ", "");
	}

	public String getExtraPackage_inActiveSectionText(){
		return ElementUtils.getText(driver, extraPackage_inActiveSection);
	}

}
