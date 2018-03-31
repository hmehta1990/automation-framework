package com.automation.framework.atdd.ui.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class SeleniumUtils {


    private static Map<String, WebDriver> drivers = new HashMap<>();

    public static WebDriver openBrowser(String browserType, String uniqueId, String jobDetail, String USERNAME, String ACCESS_KEY) {

        if (USERNAME == null || ACCESS_KEY == null) {
            Assert.fail("Missing value for environment variable(s) SAUCE_USERNAME or SAUCE_ACCESS_KEY.  Check environment configuration and try again");
        }
        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

        switch (browserType) {
            case "chromeLocal":
                if (drivers.get(uniqueId) == null) {
                    System.setProperty("webdriver.chrome.driver", "/tools/chromedriver");
                    drivers.put(uniqueId, new ChromeDriver());
                    break;
                }
            case "firefoxLocal":
                if (drivers.get(uniqueId) == null) {
                    FirefoxProfile profile = new FirefoxProfile();
                    FirefoxDriver ffd = new FirefoxDriver(new FirefoxBinary(new File(System.getProperty("user.dir"), "/drivers/geckodriver")), profile);
                    drivers.put(uniqueId, ffd);
                    break;
                }
            case "firefoxRemote":
                if (drivers.get(uniqueId) == null) {
                    DesiredCapabilities caps = DesiredCapabilities.firefox();
                    caps.setCapability("platform", "Windows 7");
                    caps.setCapability("version", "45.0");
                    caps.setCapability("screenResolution", "1600x1200");
                    caps.setCapability("parent-tunnel", "sauce_admin");
                    caps.setCapability("tunnelIdentifier", "OptumSharedTunnel-Stg");
                    caps.setCapability("maxDuration", "10800");
                    caps.setCapability("idleTimeout", "90");
                    caps.setCapability("commandTimeout", "120");
                    caps.setCapability("name", jobDetail);
                    try {
                        drivers.put(uniqueId, new RemoteWebDriver(new URL(URL), caps));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
        }
        return drivers.get(uniqueId);
    }


}
