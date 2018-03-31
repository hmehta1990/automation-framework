package com.automation.framework.atdd.ui.stepdefinitions;

import com.automation.framework.atdd.ui.pages.LoginPage;
import com.automation.framework.atdd.ui.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties Config;

    static {

        try {
            File file = new File(System.getProperty("user.dir") + "//src//main//resources//config.properties");
            Config = new Properties();
            FileInputStream fileInput = new FileInputStream(file);
            Config.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = SeleniumUtils.openBrowser(Config.getProperty("browser"), String.valueOf(Thread.currentThread().getId()), "test", "test", "test");

    }

    public String USERNAME = Config.getProperty("sauce_user");
    public String ACCESS_KEY = Config.getProperty("sauce_key");
    public LoginPage loginPage = new LoginPage(driver);

}
