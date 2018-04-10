package com.automation.framework.atdd.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageStepDefinition extends TestBase {

    @Given("^User login on to amazon application$")
    public void userLoginOnToAmazonApplication() throws Throwable {
        loginPage.loginToApplication();
    }

    @And("^User enter email address \"([^\"]*)\"$")
    public void enterEmailAddress(String email) throws Throwable {
        loginPage.enterEmailAddress(email);
    }

    @And("^user navigate to \"([^\"]*)\" page$")
    public void userNavigateToPage(String arg0) throws Throwable {

        loginPage.validateSignInPage(arg0);
    }

    @Then("^User should see the \"([^\"]*)\" button$")
    public void userShouldSeeTheButton(String arg0) throws Throwable {
        loginPage.validatesContinueButton(arg0);

    }

    @And("^User should see the \"([^\"]*)\" link$")
    public void userShouldSeeTheLink(String arg0) throws Throwable {
        loginPage.validatesNewAccountLink(arg0);
    }

    @And("^User click on the Continue button$")
    public void userClickOnTheButton() throws Throwable {
        loginPage.clickContinue();
    }

    @And("^User enter password \"([^\"]*)\"$")
    public void userEnterPassword(String password) throws Throwable {
        loginPage.enterPassword(password);

    }

    @And("^User click Sign in button$")
    public void userClickSignInButton() throws Throwable {
        loginPage.clickSingIn();
    }
}

