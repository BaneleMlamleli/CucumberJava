package org.example.StepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import io.cucumber.java.en.*;

public class ResetPassword {
    WebDriver driver = null;

    @Given("user is on password reset page")
    public void user_is_on_password_reset_page() {
        //System.setProperty("webdriver.chrome.driver", "src\\test\\java\\org\\example\\Drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("","src\\test\\java\\org\\example\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When ("user enter .*")
    public void user_enter_username(String username) {
        //driver.findElement(By.xpath(txtUsername)).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }
    
    @And ("click on Reset Password")
    public void click_on_reset_password() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then ("user is navigated to the successful password reset page")
    public void user_is_navigated_to_the_successful_password_reset_page(){
        driver.getPageSource().contains("Reset Password link sent successfully");
    }
}
