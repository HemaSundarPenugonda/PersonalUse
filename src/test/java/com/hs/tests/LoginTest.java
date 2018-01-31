package com.hs.tests;

import com.hs.pages.LoginPageActions;
import com.hs.testDataBeans.TestData;
import com.hs.testDataBeans.UsersDataBean;
import com.hs.testUtils.CustomAssertions;
import com.hs.utils.CustomLogging;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPageActions loginPage;

    String username = TestData.getUsersData().getAdmin().getUserName();
    String password = TestData.getUsersData().getAdmin().getPassWord();

//    @Test(dependsOnMethods = "testLoginWrongPassword")
    @Test(priority = 1)
    public void testSuccessfullLogin() throws InterruptedException {
        loginPage = new LoginPageActions(driver);
        navigateToLoginPage();

        loginPage.loginIntoTrueApplication(username, password);
        CustomLogging.writeToReport("INFO: User logged in with User name: " + username + "\n password: " + password + " successfully");
//		loginPage.verifySuccessfulLogin();
    }

//    @Test(priority = 0)
    public void testLoginWithOutFillingUserNamePwd() {
        loginPage = new LoginPageActions(driver);

        navigateToLoginPage();
        loginPage.clickLogInButton();

        CustomAssertions.assertText(loginPage.getAccountMissingError(), "account field is required.", "Verified error message as ");
        CustomAssertions.assertText(loginPage.getPasswordMissingEoor(), "Password field is required.", "Verified error message as ");
        loginPage.clickCancelButton();
    }

//    @Test(dependsOnMethods = "testLoginWithOutFillingUserNamePwd")
//    @Test(priority = 0)
    public void testLoginWrongPassword() {
        loginPage = new LoginPageActions(driver);

        navigateToLoginPage();

        loginPage.enterUserName(username);
        loginPage.hideKeyboard();
        loginPage.enterPassword("123");

        loginPage.clickLogInButton();

        CustomAssertions.assertText(loginPage.getWrongPasswordError(), "Invalid account or password.", "Verified error message as ");
        loginPage.clickCancelButton();

    }
}