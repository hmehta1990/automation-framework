package com.automation.framework.atdd.ui.pages;

import com.automation.framework.atdd.ui.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private By signInBtn = By.cssSelector("a[data-nav-role='signin']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToApplication() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com/");
        TestUtils.click(signInBtn, driver);
    }
}
