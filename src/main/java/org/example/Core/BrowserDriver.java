package org.example.Core;

import org.example.Tools.SeleniumDriverUtility;
import org.openqa.selenium.WebDriver;

public class BrowserDriver {
    public static WebDriver driver;
    private static SeleniumDriverUtility seleniumDriverUtility;
    private static SeleniumDriverUtility.BrowserType browser;

    public static void setUpSeleniumDriver() {
        browser = SeleniumDriverUtility.BrowserType.CHROME;
        seleniumDriverUtility = new SeleniumDriverUtility(browser);
    }

    public static void initializePageObjects() {
        driver = seleniumDriverUtility.getDriver();
    }

    public static void closeBrowser() {
        driver.quit();
        driver.close();
    }
}