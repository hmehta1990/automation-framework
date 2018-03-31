package com.automation.framework.atdd.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

    public static void click(By by, WebDriver driver) {
        try {
            explicitWait(by, driver);
            driver.findElement(by).click();
        } catch (NoSuchElementException nse) {

        }
    }

    private static void explicitWait(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
