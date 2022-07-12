package pages.AGE.main_pages;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameTextbox = By.id("username");
    By passwordTextbox = By.id("password");
    By submitButton = By.id("submit");

    public LoginPage loginPage(String baseUrl){
        driver.get(baseUrl + "login" + propertyManager.getProperty("testingKey", "AGE"));
        logger.info("Log In page loaded");
        return this;
    }

    public MembersPage signIn(){
        writeText(usernameTextbox, propertyManager.getProperty("email", "AGE"));
        writeText(passwordTextbox, propertyManager.getProperty("password", "AGE"));
        click(submitButton);
        logger.info("Sign in form loaded");
        return new MembersPage(driver);
    }
}
