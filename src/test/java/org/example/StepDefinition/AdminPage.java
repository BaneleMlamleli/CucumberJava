package org.example.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;

import io.cucumber.java.en.*;

public class AdminPage {

    //i[@class='oxd-icon bi-chevron-left']
    //i[@class='oxd-icon bi-chevron-right']
    //i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']
    //*[@id="oxd-toaster_1"]
    //p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']   

    WebDriver driver = null;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    private WebElement successToasterMessageBoxElement;

    @Given("user is on the admin page")
    public void user_is_on_the_admin_page() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\org\\example\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        driver.manage().window().maximize();
    }

    @And("user click on the Admin button")
    public void user_clicks_on_the_Add_button() {
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active toggle']//span[1]")).click();
        //a[@class='oxd-main-menu-item active toggle']
    }
    
    @And("user clicks on Add button")
    public void user_clicks_on_Add_button() {
        System.out.println("And");
    }
    
    @When("^user select user role (.*)")
    public void user_select_user_role(String userRole) {
        System.out.println("When");
    }
    
    @And("^user select user status (.*)")
    public void user_select_user_status(String userStatus) {
        System.out.println("And");
    }

    @And("^user enters password (.*) and confirmation password (.*)")
    public void user_enters_password_and_confirms_password() {
        System.out.println("And");
    }
    
    @And("^enter employee name(.*)")
    public void enter_employee_name() {
        System.out.println("And");
    }
    
    @And("^enter username (.*)")
    public void enter_username() {
        System.out.println("And");
    }
    
    @Then("click on Save button")
    public void click_on_Save_button() {
        System.out.println("Then");
    }
    
    @And("successful toaster box appears")
    public void successful_toaster_box_appears() {
        if (successToasterMessageBoxElement.isDisplayed()) {
            System.out.println("User successfully created");
        } else {
            System.out.println("User was not created. Error might have happened");
        }
    } 
}
