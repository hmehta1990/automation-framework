package com.automation.framework.atdd.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    public static void click(By by, WebDriver driver) {
        try {
            explicitWait(by, driver);
            driver.findElement(by).click();
        } catch (NoSuchElementException nse) {

        }
    }

    private static void explicitWait(By by, WebDriver driver) {
        // WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void sendKeys(String keys, WebDriver driver, By by) {
        explicitWait(by, driver);
        driver.findElement(by).sendKeys(keys);
    }

    public static void isDisplayed() {

    }

}