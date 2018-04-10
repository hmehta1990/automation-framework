package com.automation.framework.atdd.ui.pages;

import com.automation.framework.atdd.ui.utils.TestUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private By signInBtn = By.cssSelector("a[id='nav-link-accountList']");
    private By emailAddressTextBox = By.cssSelector("input[name*='email']");
    private By header1 = By.cssSelector("h1[class='a-spacing-small']");
    private By continueBtn = By.xpath("//*[@id='continue-announce']");
    private By newAccountBtn = By.cssSelector("a[id='createAccountSubmit']");
    private By passwordTextBox = By.cssSelector("input[id=ap_password]");
    private By signInSubmitBtn = By.cssSelector("input[id='signInSubmit'][type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Its for login
 
    public void loginToApplication() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com/");
        TestUtils.click(signInBtn, driver);
    }

    /**
     * @param email Enter valid email address.
     */
    public void enterEmailAddress(String email) {
        TestUtils.sendKeys(email, driver, this.emailAddressTextBox);
    }

    public void validateUserName() {
    }

    public void validateSignInPage(String header) {
        String h1 = driver.findElement(this.header1).getText();
        Assert.assertEquals(header, h1);
    }

    public void validatesContinueButton(String ctn) {
        String h2 = driver.findElement(this.continueBtn).getText();
        Assert.assertEquals(ctn, h2);

    }

    public void validatesNewAccountLink(String newAccount) {
        String h3 = driver.findElement(this.newAccountBtn).getText();
        Assert.assertEquals(newAccount, h3);

    }

    public void clickContinue() {
        TestUtils.click(continueBtn, driver);

    }

    public void enterPassword(String password) {
        TestUtils.sendKeys(password, driver, this.passwordTextBox);
    }

    public void clickSingIn() {
        TestUtils.click(signInSubmitBtn, driver);

    }
}
