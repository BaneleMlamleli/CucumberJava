package org.example.Tools;

import org.example.Core.BrowserDriver;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriverUtility extends BrowserDriver{
    public enum BrowserType {CHROME, FIREFOX, IE} //choosing browser type

    private WebDriver driver;
    private BrowserType currentBrowser;

    public WebDriver getDriver() {
        return driver;
    }

    public SeleniumDriverUtility(BrowserType browser) {
        this.currentBrowser = browser;
        launchDriver();
    }

    public void launchDriver() {
        try {
            switch (currentBrowser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    this.driver = new FirefoxDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    InternetExplorerOptions ieOpts = new InternetExplorerOptions();
                    ieOpts.ignoreZoomSettings();
                    ieOpts.destructivelyEnsureCleanSession();
                    ieOpts.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                    ieOpts.setCapability("ignoreProtectedModeSettings", true);
                    this.driver = new InternetExplorerDriver(ieOpts);
                    break;
                default:
                    System.err.println("Invalid Browser");
                    break;
            }
        } catch (Exception ex) {
            System.err.println("[Error]: Error Launching driver " + ex.getMessage());
        }

        this.driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
