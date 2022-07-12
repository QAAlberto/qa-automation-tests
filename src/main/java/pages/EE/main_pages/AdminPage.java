package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    By membersLink = By.xpath("//a[@href='https://sandboxadmin.divineoriginshealth.com/users']");
    By addNewMembershipButton = By.xpath("//a[@href='https://sandboxadmin.divineoriginshealth.com/users/add']");

    public void loginPage(String adminURL){
        driver.get(adminURL + "login");
        logger.info("Admin Login Page loaded");
    }

    public void signIn(){
        writeText(usernameField, propertyManager.getProperty("adminUsername", "EE"));
        writeText(passwordField, propertyManager.getProperty("adminPassword", "EE"));
        click(signInButton);
    }

    public void membersPage(){
        click(membersLink);
    }

    public void clickAddNewMembership(){
        click(addNewMembershipButton);
    }
}
