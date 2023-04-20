package org.example.StepDefinition;

import org.example.Core.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.*;


public class LoginSteps {

    WebDriver driver = null;
    BrowserDriver browserDriver = new BrowserDriver();
    FirefoxOptions options = new FirefoxOptions();

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;
    
    @FindBy(xpath = "//input[@name='username']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement txtPassword;

    @Given("browser is open")
    public void browser_is_open() {
        browserDriver.initialiseWebDriver();
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
        System.out.println("user enters username and password");
        //driver.findElement(By.name("username")).sendKeys(username);
        //driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // @When("user enters username and password")
    // public void user_enters_username_and_password(){
    //     driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    //     driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
    //     try {
    //         Thread.sleep(2000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @When("user enters username and password")
    // public void user_enters_username_and_password(){
    //     txtUsername.sendKeys("Admin");
    //     txtPassword.sendKeys("admin123");
    //     try {
    //         Thread.sleep(5000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //btnSubmit.click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page(){
        driver.getPageSource().contains("Time at Work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
