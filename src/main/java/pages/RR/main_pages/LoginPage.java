package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameTextbox = By.id("username");
    By passwordTextbox = By.id("password");
    By submitButton = By.id("submitButton");

    public void loginPage(String baseUrl){
        driver.get(baseUrl + "login" + propertyManager.getProperty("testingKey", "RR"));
        logger.info("Log In page loaded");
    }

    public void signIn(){
        writeText(usernameTextbox, propertyManager.getProperty("email", "RR"));
        writeText(passwordTextbox, propertyManager.getProperty("password", "RR"));
        click(submitButton);
        logger.info("Sign in form loaded");
    }
}
