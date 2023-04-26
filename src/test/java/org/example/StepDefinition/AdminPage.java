package org.example.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;

import io.cucumber.java.en.*;

public class AdminPage {

    WebDriver driver = null;

    @And("user is on the admin page")
    public void user_is_on_the_admin_page() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
        driver.manage().window().maximize();
    }
    
    @And("user clicks on Add button")
    public void user_clicks_on_Add_button() {
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
    }
    
    @And("^user select user role (.*)")
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
    
    @And("click on Save button")
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
