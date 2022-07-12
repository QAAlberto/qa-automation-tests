package pages.PPS.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("username");
    By password = By.id("password");
    By submitButton = By.id("submitButton");

    public void signIn(){
        writeText(username, propertyManager.getProperty("username", "PPS"));
        writeText(password, propertyManager.getProperty("password", "PPS"));
        click(submitButton);
    }

    public void loginPage(String baseUrl){
        driver.get(baseUrl + "/admin/login");
        logger.info("Login Page loaded");
    }
}
