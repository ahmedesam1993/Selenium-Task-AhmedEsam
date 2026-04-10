package Execution;

import BaseClass.BaseTest;
import Pages.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginScenarios extends BaseTest {

    // TestCase 1: Successful Login
    @Test(dataProvider = "LoginTestData", description = "Test login with different scenarios")

    public void testLogin(JsonObject testData) {
        String testCase = testData.get("testCase").getAsString();
        String username = testData.get("username").getAsString();
        String password = testData.get("password").getAsString();
        String expectedResult = testData.get("expectedResult").getAsString();

        System.out.println("\n========== " + testCase + " ==========");
        System.out.println("Username: " + (username.isEmpty() ? "EMPTY" : username));
        System.out.println("Password: " + (password.isEmpty() ? "EMPTY" : password));

        pageObjectManager.getLoginPage().waitForMessageToDisappear();
        pageObjectManager.getLoginPage().enterUsername(username);
        pageObjectManager.getLoginPage().enterPassword(password);
        pageObjectManager.getLoginPage().clickSignIn();

        if (expectedResult.equals("success")) {
            testSuccessLogin();
        } else if (expectedResult.equals("error")) {
            testInvalidLogin();
        } else if (expectedResult.equals("fieldErrors")) {
            testEmptyFieldsValidation();
        }

        System.out.println(testCase + ": PASSED\n");
    }

    private void testSuccessLogin() {


        Assert.assertTrue(pageObjectManager.getHomePage().checkSuccessMessage(),
                "Success message should be displayed");
        Assert.assertEquals(pageObjectManager.getHomePage().getSuccessMessage(),pageObjectManager.getHomePage().expectedSuccessMessage());
        System.out.println("Success message displayed correct as expected");
    }

    private void testInvalidLogin() {
        Assert.assertTrue(pageObjectManager.getLoginPage().checkInvalidLoginErrorMessage(),
                "Error message should be displayed");

        Assert.assertEquals(pageObjectManager.getLoginPage().getInvalidLoginErrorMessage(),pageObjectManager.getLoginPage().expectedInvalidLoginErrorMessage());

        System.out.println("Error message displayed correct as expected");
    }

    private void testEmptyFieldsValidation() {
        Assert.assertTrue(pageObjectManager.getLoginPage().checkUsernameErrorMessage(),
                "Username error should be displayed");
        Assert.assertEquals(pageObjectManager.getLoginPage().getUsernameErrorMessage(),pageObjectManager.getLoginPage().expectedUsernameErrorMessage());

    Assert.assertTrue(pageObjectManager.getLoginPage().checkPasswordErrorMessage(),
                "Password error should be displayed");
        Assert.assertEquals(pageObjectManager.getLoginPage().getPasswordErrorMessage(),pageObjectManager.getLoginPage().expectedPasswordErrorMessage());

        System.out.println("Username error displayed correct as expected");
        System.out.println("Password error displayed correct as expected");
    }
}
