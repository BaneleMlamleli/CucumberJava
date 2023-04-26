package org.example.StepDefinition;

import org.example.Core.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.*;


public class Login {

    WebDriver driver = null;
    BrowserDriver browserDriver = new BrowserDriver();
    FirefoxOptions options = new FirefoxOptions();

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;
    
    @FindBy(xpath = "//input[@name='username']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//i[@class='oxd-icon bi-chevron-left']")
    private WebElement closedChevroElement;

    @FindBy(xpath = "//i[@class='oxd-icon bi-chevron-right']")
    private WebElement openedChevronMenuElement;

    @Given("browser is open")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\org\\example\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
    }
}

