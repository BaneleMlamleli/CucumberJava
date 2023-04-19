package org.example.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    WebDriver driver = null;

    public void initialiseWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\org\\example\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "src\\test\\java\\org\\example\\Drivers\\geckodriver.exe");
        // Because Firefox was not installed in its defautl path I've to explicity define where to find the firefox binary file.
        //options.setBinary("C:\\Users\\BaneleMlamleli\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        //driver = new FirefoxDriver(options);

        //System.setProperty("webdriver.edge.driver", "src\\test\\java\\org\\example\\Drivers\\msedgedriver.exe");
        //driver = new EdgeDriver(); 

        driver.manage().window().maximize();
    }
}