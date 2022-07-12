package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    By password1Textbox = By.id("password1");
    By password2Textbox = By.id("password2");
    By submitButton = By.id("submitChange");
    By membersTitle = By.id("pageTitle");
    By xButton = By.xpath("//button[contains(text(),'✕')]");

    public void closeModal(){
        click(xButton);
    }

    public void changePassword(String password){
        writeText(password1Textbox, password);
        writeText(password2Textbox, password);
        click(submitButton);
    }

    public void verifyPasswordChange(){
        assertEquals(membersTitle, "Password Change Complete");
    }
}
