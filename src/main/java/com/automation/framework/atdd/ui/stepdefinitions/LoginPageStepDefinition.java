package com.automation.framework.atdd.ui.stepdefinitions;

import cucumber.api.java.en.Given;

public class LoginPageStepDefinition extends TestBase {

    @Given("^User login on to amazon application$")
    public void userLoginOnToAmazonApplication() throws Throwable {
        loginPage.loginToApplication();
    }

}
